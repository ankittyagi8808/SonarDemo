package com.qrux.discussion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.domain.NotificationDto;
import com.qrux.discussion.repositories.AplozRepository;

@RestController
public class NotificationController {
	@Autowired
	private AplozRepository aplozRepository;
	
       // This is a notification controller
	@RequestMapping("/an/{contactId}")
	public List<NotificationDto> getNotifications(@PathVariable("contactId") Long conatcId){
		
		return aplozRepository.getNotifications(conatcId);
	}

}
