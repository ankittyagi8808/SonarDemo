package com.qrux.discussion.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

	@JsonProperty("categoryId")
	private int categoryId;
	
	@JsonProperty("categoryDescription")
	private String categoryDescription;
	
	@JsonProperty("createdBy")
	private int createdBy;
	
	@JsonProperty("creationDate")
	private String creationDate;

	@JsonProperty("lastUpdateDate")
	private String lastUpdateDate;
	
	@JsonProperty("group")
	private GroupDto group;
	
}
