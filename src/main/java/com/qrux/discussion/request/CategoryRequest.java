package com.qrux.discussion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CategoryRequest {

	@JsonProperty("categoryDescription")
	private String categoryDescription;
	
	@JsonProperty("groupId")
	private int groupId;
}
