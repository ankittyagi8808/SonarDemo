package com.qrux.discussion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TopicRequest {
	@JsonProperty("topicId")
	private long topicId;
	
	@JsonProperty("topicDescription")
	private String topicDescription;
	
	@JsonProperty("forumId")
	private int forumId;
}
