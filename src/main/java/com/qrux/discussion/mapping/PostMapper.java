package com.qrux.discussion.mapping;

import org.modelmapper.PropertyMap;

import com.qrux.discussion.domain.Post;
import com.qrux.discussion.response.PostDto;

public class PostMapper extends PropertyMap<Post,PostDto>{

	@Override
	protected void configure() {	
		map().setTopicId(source.getTopic().getTopicId());
		map().setPostId(source.getPostId());
		map().setPostDescription(source.getPostDescription());
		map().setNoOflikes(source.getNoOflikes());
	    map().setParentId(source.getParentId());
	    map().setFirstDisplayName(source.getMasterContact().getContactFirstDisplayName());
	    map().setLastDisplayName(source.getMasterContact().getContactLastDisplayName());
	    map().setProfilePhoto("https://viima-app.s3.amazonaws.com/media/public/defaults/user-icon.png");
	}

}
