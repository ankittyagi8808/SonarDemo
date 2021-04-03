package com.qrux.discussion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.request.ForumRequest;
import com.qrux.discussion.response.ForumDto;
import com.qrux.discussion.service.ForumService;
import com.qrux.discussion.service.UserService;

@RestController
public class ForumController {

	@Autowired
	ForumService forumService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/addForum" , produces= MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ForumDto> addCategory(@RequestBody ForumRequest forumRequest) {
		return new ResponseEntity<ForumDto>(forumService.addForum(forumRequest.getForumDescription(),forumRequest.getCategoryId(),userService.giveUserId()), HttpStatus.OK);

	}
	

}
