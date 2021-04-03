package com.qrux.discussion.mapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(new TopicMapper());
		modelMapper.addMappings(new PostMapper());
	    

	    Converter<Timestamp, String> toStringDate = new AbstractConverter<Timestamp, String>() {

			@Override
			protected String convert(Timestamp source) {
				DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("MMM dd,yyyy");
				String output = source.toLocalDateTime().toLocalDate().format(newPattern);
				return output;
			}
	       
	    };
	    modelMapper.createTypeMap(Timestamp.class, String.class);
	    modelMapper.addConverter(toStringDate);
	    
		return modelMapper;
	}
	
}
