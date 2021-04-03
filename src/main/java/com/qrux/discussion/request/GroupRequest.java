package com.qrux.discussion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GroupRequest {

	@JsonProperty("groupDescription")
	private String groupDescription;
	
	@JsonProperty("groupType")
	private String groupType;
	
	
}
