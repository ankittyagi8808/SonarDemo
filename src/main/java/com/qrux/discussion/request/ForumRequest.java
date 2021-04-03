package com.qrux.discussion.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ForumRequest {

	@JsonProperty("forumDescription")
	public String forumDescription;
	@JsonProperty("categoryId")
	public int categoryId;
}
