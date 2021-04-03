package com.qrux.discussion.response;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PostDto {

	@JsonProperty("id")
	private int postId;

	@JsonProperty("content")
	private String postDescription;

	@JsonProperty("created")
	private String creationDate;

	@JsonProperty("modified")
	private String lastUpdatedDate;

	@JsonProperty("upvote_count")
	private int noOflikes;

	@JsonProperty("topic")
	private long topicId;
	
	@JsonProperty("parent")
	private String parentId;

	@JsonProperty("creator")
	private long createdBy;
	
	@JsonProperty("lastUpdateBy")
	private long lastUpdateBy;

	@JsonProperty("fullname")
	 private String fullName;
	
	@JsonProperty("firstDisplayName")
	private String firstDisplayName;
	
	@JsonProperty("lastDisplayName")
	private String lastDisplayName;
	
	@JsonProperty("profile_picture_url")
	private String profilePhoto;
}
