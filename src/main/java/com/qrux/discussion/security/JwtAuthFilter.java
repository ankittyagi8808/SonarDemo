package com.qrux.discussion.security;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import com.qrux.discussion.CurrentTenantId;
@Configuration
public class JwtAuthFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER_STRING = "Authorization";
    private static final String AUTH_BEARER_STRING = "Bearer";
   
    @Value("#{'${cognito.userPoolId}'}")
	private  String userPoolId;
    
    @Value("#{'${cognito.region}'}")
	private  String region;
    
    @Value("#{'${jwks.url}'}")
	private String jwkUrl;
    
	private static final String COGNITO_IDENTITY_POOL_URL = "https://cognito-idp.%s.amazonaws.com/%s";
	private static final String JSON_WEB_TOKEN_SET_URL_SUFFIX = "/.well-known/jwks.json";
	
	@Value("#{'${cognito.connectionTimeout}'}")
	private int connectionTimeout = 2000;
	
	@Value("#{'${cognito.readTimeout}'}")
	private int readTimeout = 2000;
	
	
    // should cache keys
    RemoteJWKSet<?> remoteJWKSet;
     
    public String getJwkUrl() {
        if (jwkUrl==null || jwkUrl.trim().length()==0) {
            return String.format(COGNITO_IDENTITY_POOL_URL + JSON_WEB_TOKEN_SET_URL_SUFFIX,region,userPoolId);
        }
        System.out.println(COGNITO_IDENTITY_POOL_URL);
    	 //System.out.println("url:"+jwkUrl);
        return jwkUrl;
    }

    public String getCognitoIdentityPoolUrl() {
        return String.format(COGNITO_IDENTITY_POOL_URL,region,userPoolId);
    }
  

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
    	
        String header = req.getHeader(AUTH_HEADER_STRING);
      if(header!=null) {
        header=header	.replace(AUTH_BEARER_STRING,"");
        try {
            JWT jwt = JWTParser.parse(header);

            
            // check if issuer is our user pool
            if (getCognitoIdentityPoolUrl().equals(jwt.getJWTClaimsSet().getIssuer())) {
            	ResourceRetriever resourceRetriever = new DefaultResourceRetriever(connectionTimeout, readTimeout);
                URL JWKUrl = new URL(getJwkUrl());
                this.remoteJWKSet = new RemoteJWKSet(JWKUrl,resourceRetriever);

                JWSKeySelector keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, remoteJWKSet);

                ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
                jwtProcessor.setJWSKeySelector(keySelector);

                // check token
                JWTClaimsSet claimsSet = jwtProcessor.process(jwt, null);
                List<GrantedAuthority> authorities = new ArrayList<>();
                List<String> groups=null;
                if(claimsSet.getClaim("cognito:groups")!=null) { // process roles (gropus in cognito)
                	groups = (List<String>) claimsSet.getClaim("cognito:groups");
                groups.forEach(s -> {
                   // logger.info(s);
                            authorities.add(new SimpleGrantedAuthority(s));
                });
               }
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        claimsSet,
                        null,
                        authorities
                );

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                if(groups!=null) {
             	   if(groups.contains("abg_ultra_admin") || groups.contains("abg_ultra_users")) {
 		            	  CurrentTenantId.set("abg_ultra");
 			      		}
 			      		else if(groups.contains("kancor_admin") || groups.contains("kancor_users")) {
 			      			 CurrentTenantId.set("kancor");
 			      		}
 			      		else if(groups.contains("acg_admin") || groups.contains("acg_users")) {
 			      			 CurrentTenantId.set("acg");
 			      		}
 			      		else if(groups.contains("sales_admin") || groups.contains("sales_users")) {
 			      			 CurrentTenantId.set("sales");
 			      		}
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JOSEException e) {
            e.printStackTrace();
        } catch (BadJOSEException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            // in case that header is null
            e.printStackTrace();
        }
      }
       
        chain.doFilter(req, res);
    }
}
