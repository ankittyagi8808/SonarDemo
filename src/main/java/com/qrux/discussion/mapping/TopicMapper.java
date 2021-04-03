package com.qrux.discussion.mapping;



import java.time.format.DateTimeFormatter;

import org.modelmapper.PropertyMap;

import com.qrux.discussion.domain.Topic;
import com.qrux.discussion.response.TopicDto;

public class TopicMapper extends PropertyMap<Topic,TopicDto>{

	@Override
	protected void configure() {
		map().setCreatedBy(source.getMasterContact().getContactId());
		map().setContactFirstName(source.getMasterContact().getContactFirstDisplayName());
		map().setContactLastName(source.getMasterContact().getContactLastDisplayName());
	}

}
