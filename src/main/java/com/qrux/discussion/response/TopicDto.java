package com.qrux.discussion.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class TopicDto {

	@JsonProperty("topicId")
	private long topicId;

	@JsonProperty("TopicTitle")
	private String topicTitle;
	
	@JsonProperty("topicDescription")
	private String topicDescription;
	
	@JsonProperty("noOfComments")
	private int noOfComments;
	
	@JsonProperty("noOfLikes")
	private int  noOfLikes;
	
	@JsonProperty("noOfViews")
	private int noOfViews;
	
	@JsonProperty("lastUpdateDate")
	private String lastUpdateDate;
	
	@JsonProperty("createDate")
	 private String createDate;
	
	@JsonProperty("createByFirstName")
	 private String contactFirstName;
	 
	@JsonProperty("createByLasttName")
	 private String contactLastName;
	
	@JsonProperty("status")
	private String status;

	@JsonProperty("createdBy")
	private long createdBy;
	
	@JsonProperty("form")
	ForumDto form;
	

}
