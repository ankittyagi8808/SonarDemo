package com.qrux.discussion.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qrux.discussion.domain.Forum;
import com.qrux.discussion.domain.Topic;
import com.qrux.discussion.domain.User;
import com.qrux.discussion.repositories.TopicRepository;
import com.qrux.discussion.response.TopicDto;

@Service
public class DiscussionForumService {

	@Autowired
	TopicRepository topicRepository;

	@Autowired
	ModelMapper mapper;

	public List<TopicDto> getAllActiveDiscussion() {
		List<Topic> topic = topicRepository.getAllActiveTopic();
		List<TopicDto> dots = topic.stream().map(t -> mapper.map(t, TopicDto.class)).collect(Collectors.toList());
		return dots;
	}

	@Transactional
	public TopicDto addNewTopic(final String topicDescription,final int forumId,final long userId) {
		Topic topic = new Topic();
		topic.setTopicDescription(topicDescription);
		// topic.setCreatedBy(userId);
		Forum forum = new Forum();
		forum.setForumId(forumId);
		topic.setForm(forum);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		topic.setCreateDate(timestamp);
		topic.setLastUpdateDate(timestamp);
		topic.setStatus("A");
		topic.setLastUpdateBy(userId);
		topicRepository.save(topic);
		return mapper.map(topic, TopicDto.class);
	}

	public TopicDto getTopicById(final int discussionId) {
		Topic topic = topicRepository.getTopicById(Long.valueOf(discussionId));
		return mapper.map(topic, TopicDto.class);
	}

	public List<TopicDto> getActiveDiscussionByForumId(final Integer forumId) {
		List<Topic> topic = topicRepository.getAllTopicByForumId(forumId);
		List<TopicDto> dots = topic.stream().map(t -> mapper.map(t, TopicDto.class)).collect(Collectors.toList());
		return dots;
	}

	@Transactional
	public void incrementNoOfComments(final Long topicId) {
		topicRepository.updateNoOfComments(topicId);
	}

	@Transactional
	public void incrementNoOfLikes(final Long topicId) {
		topicRepository.updateNoOfLikes(topicId);
		
	}
	
	@Transactional("tenantTransactionManager")
	public void incrementNoOfView(final Long topicId) {
		topicRepository.updateNoOfViews(topicId);
		
	}

}
