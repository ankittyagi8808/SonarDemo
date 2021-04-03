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
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.request.PostRequest;
import com.qrux.discussion.response.PostDto;
import com.qrux.discussion.service.PostService;
import com.qrux.discussion.service.UserService;

@RestController
public class PostController {
 
      // GO To Post
	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/addPost", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDto> addNewPost(@RequestBody PostRequest postrequest) {
		return new ResponseEntity<PostDto>(postService.addNewPost(postrequest.getTopicId(),
				postrequest.getPostDescription(), postrequest.getUserId(),String.valueOf(postrequest.getParent())), HttpStatus.OK);
	}

	@GetMapping(value = "/getPostsForTopic/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostDto>> addNewPost(@PathVariable("id") long topicId) {
		return new ResponseEntity<List<PostDto>>(postService.getAllPostForTopic(topicId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/editPost", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostDto> editPostt(@RequestBody PostRequest postrequest) {
		return new ResponseEntity<PostDto>(postService.editPost(Integer.valueOf(postrequest.getPostId()),
				postrequest.getPostDescription()), HttpStatus.OK);
	}

	
	@PutMapping(value = "/incrementPostLikes")
	public ResponseEntity<HttpStatus> incrementLikes(@RequestBody PostRequest postRequest) {
		postService.incrementNoOfLikes(Integer.valueOf(postRequest.getPostId()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/decrementPostLikes")
	public ResponseEntity<HttpStatus> decrementPostLikes(@RequestBody PostRequest postRequest) {
		postService.decrementNoOfLikes(Integer.valueOf(postRequest.getPostId()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
