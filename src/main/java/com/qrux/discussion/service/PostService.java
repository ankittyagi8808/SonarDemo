package com.qrux.discussion.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.util.StringUtils;
import com.qrux.discussion.domain.MasterContact;
import com.qrux.discussion.domain.Post;
import com.qrux.discussion.domain.Topic;
import com.qrux.discussion.mapping.PostMapper;
import com.qrux.discussion.mapping.TopicMapper;
import com.qrux.discussion.repositories.PostRepository;
import com.qrux.discussion.repositories.TopicRepository;
import com.qrux.discussion.response.PostDto;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	TopicRepository topicRepository;

	
	ModelMapper modelMapper = getModelMapper();

	@Transactional("tenantTransactionManager")
	public PostDto addNewPost(final long topicId, final String postDescription, final long userId,final String parentId) {
		Post post = new Post();
		post.setPostDescription(postDescription);
	     MasterContact masterContact = new MasterContact();
	    masterContact.setContactId(userId);
	    post.setMasterContact(masterContact);
	    if(!StringUtils.isNullOrEmpty(parentId) && parentId != "null")
	    {
	     post.setParentId(parentId);
	    }
	    Timestamp now = new Timestamp(System.currentTimeMillis());
		post.setCreationDate(now);
		post.setLastUpdateBy(userId);
		post.setLastUpdatedDate(now);
		Topic topic = new Topic();
		topic.setTopicId(topicId);
		post.setTopic(topic);
		postRepository.save(post);
		topicRepository.updateNoOfComments(topicId);
		return modelMapper.map(post, PostDto.class);
	   
	}

	public List<PostDto> getAllPostForTopic(long topicId) {
		List<Post> posts = postRepository.getAllPostByTopicId(topicId);
		List<PostDto> postDtos = posts.stream().map(t -> modelMapper.map(t, PostDto.class))
				.collect(Collectors.toList());
		postDtos.forEach(t -> {t.setFullName(t.getFirstDisplayName() + " " + t.getLastDisplayName());});
		return postDtos;
	}

	@Transactional
	public PostDto editPost(final int postId,final String postDescription) {
		postRepository.updatePost(postId, postDescription);
		Post post =postRepository.findById(postId).get();
      return modelMapper.map(post, PostDto.class);
	}

	@Transactional
	public void incrementNoOfLikes(int postId) {
		postRepository.updateNoOfLikes(postId);
		
	}
	
	@Transactional
	public void decrementNoOfLikes(int postId) {
		postRepository.decrementNoOfLikes(postId);
		
	}
	
	private ModelMapper getModelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(new PostMapper());
		return modelMapper;
	}

}
