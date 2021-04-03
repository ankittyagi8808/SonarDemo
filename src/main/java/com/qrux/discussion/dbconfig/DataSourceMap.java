package com.qrux.discussion.dbconfig;

import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.qrux.discussion.dbconfig.tenants.Tenant;
import com.qrux.discussion.dbconfig.tenants.TenantRepository;


@SuppressWarnings("serial")
@Component
public class DataSourceMap extends HashMap<Object, Object> implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Value("${db.driver-class-name}")
	private String driverClass;
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object get(Object key) {
    	if(key==null)
    	{
    		key="kancor";
    	}
        Object value = super.get(key);
        if (value == null) {
            TenantRepository repo = applicationContext.getBean(TenantRepository.class);
            Tenant tenant=repo.findById((String) key).get();
            if (tenant != null) {
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName(driverClass);
                dataSource.setUrl(tenant.getUrl());
                dataSource.setUsername(tenant.getUsername());
                dataSource.setPassword(tenant.getPassword());
                value = dataSource;
                super.put(key, value);
            }
        }
        return value;
    }

}
