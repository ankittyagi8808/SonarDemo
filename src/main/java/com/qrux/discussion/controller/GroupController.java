package com.qrux.discussion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.request.GroupRequest;
import com.qrux.discussion.response.GroupDto;
import com.qrux.discussion.service.GroupService;
import com.qrux.discussion.service.UserService;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	UserService userService;
     
        // Commit my changes
       // Please include amend also
	@PostMapping(value = "/addGroup" , produces= MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GroupDto> addGroup(@RequestBody GroupRequest groupRequest) {
		return new ResponseEntity<GroupDto>(groupService.addGroup(groupRequest.getGroupDescription(),groupRequest.getGroupType(),userService.giveUserId()), HttpStatus.OK);
	}

}
