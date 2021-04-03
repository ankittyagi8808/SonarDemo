package com.qrux.discussion.service;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrux.discussion.domain.Group;
import com.qrux.discussion.repositories.GroupRepository;
import com.qrux.discussion.response.GroupDto;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	 @Autowired
	 ModelMapper  modelMapper;
	
	@Transactional
	public GroupDto addGroup(final String groupDescription,final String groupType,final int userId) {
		Group group = new Group();
		group.setGroupDescription(groupDescription);
		group.setGroupType(groupType);
		group.setCreatedBy(userId);
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		group.setCreatedDate(timeStamp);
		groupRepository.save(group);
		return modelMapper.map(group, GroupDto.class);
	}
}
