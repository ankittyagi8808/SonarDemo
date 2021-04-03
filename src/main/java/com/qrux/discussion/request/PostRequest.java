package com.qrux.discussion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostRequest {

	@JsonProperty("id")
	private String postId;

	@JsonProperty("content")
	private String postDescription;
	
	@JsonProperty("topicId")
	private int topicId;
	
	@JsonProperty("parent")
	private String parent;
	
	@JsonProperty("userId")
	private long userId;
}
