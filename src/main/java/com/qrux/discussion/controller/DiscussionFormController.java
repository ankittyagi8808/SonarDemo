package com.qrux.discussion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.request.TopicRequest;
import com.qrux.discussion.response.TopicDto;
import com.qrux.discussion.service.DiscussionForumService;
import com.qrux.discussion.service.UserService;

@RestController
public class DiscussionFormController {

       // Demo for New Recurise Branchs
	@Autowired
	DiscussionForumService discussionForumService;
	
	@Autowired
	UserService userService;

	@GetMapping(value = "/discussions")
	public ResponseEntity<List<TopicDto>> getAllDiscussion() {
		return new ResponseEntity<List<TopicDto>>(discussionForumService.getAllActiveDiscussion(), HttpStatus.OK);

	}
	
	
	@PostMapping(value = "/addDiscussion",consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopicDto> addDiscussion(@RequestBody TopicRequest topicRequest) {
		return new ResponseEntity<TopicDto>(discussionForumService.addNewTopic(topicRequest.getTopicDescription(),topicRequest.getForumId(),userService.giveUserId()),HttpStatus.OK);

	}

	
	@GetMapping(value = "/discussions/{id}")
	public ResponseEntity<TopicDto> getDiscussionById(@PathVariable("id") Integer id) {
		return new ResponseEntity<TopicDto>(discussionForumService.getTopicById(id), HttpStatus.OK);

	}
	
	
	@GetMapping(value = "/discussionForForum")
	public ResponseEntity<List<TopicDto>> getAllDiscussion(@RequestParam(name="forumId",required=true) Integer forumId) {
		return new ResponseEntity<List<TopicDto>>(discussionForumService.getActiveDiscussionByForumId(forumId),HttpStatus.OK);

	}
	
	@PutMapping(value = "/incrementComments")
	public ResponseEntity<HttpStatus> incrementComments(@RequestBody TopicRequest topicRequest) {
		discussionForumService.incrementNoOfComments(topicRequest.getTopicId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/incrementLikes")
	public ResponseEntity<HttpStatus> incrementLikes(@RequestBody TopicRequest topicRequest) {
		discussionForumService.incrementNoOfLikes(topicRequest.getTopicId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/incrementViews")
	public ResponseEntity<HttpStatus> incrementViews(@RequestBody TopicRequest topicRequest) {
		discussionForumService.incrementNoOfView(topicRequest.getTopicId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
