package com.qrux.discussion.service;

import java.sql.Timestamp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrux.discussion.domain.Categories;
import com.qrux.discussion.domain.Forum;
import com.qrux.discussion.repositories.ForumRepository;
import com.qrux.discussion.response.ForumDto;

@Service
public class ForumService {

	@Autowired
	ForumRepository forumRepository;

	@Autowired
	ModelMapper modelMapper;
	
	

	public ForumDto addForum(final String forumDescription,final int categoryId,final int giveUserId) {
		Forum forum = new Forum();
		forum.setForumDescription(forumDescription);
		Categories category = new Categories();
		category.setCategoryId(categoryId);
		forum.setCategories(category);
		Timestamp now = new Timestamp(System.currentTimeMillis());
		forum.setCreationDate(now);
		forum.setLastUpdateDate(now);
		forumRepository.save(forum);
		return modelMapper.map(forum, ForumDto.class);
	}


}
