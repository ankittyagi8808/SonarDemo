package com.qrux.discussion.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GroupDto {

	@JsonProperty("groupId")
	public int groupId;
	
	@JsonProperty("groupDescription")
    public String groupDescription;
	
	@JsonProperty("groupType")
    public String groupType;
	
	@JsonProperty("createdBy")
	public int createdBy;
	
	@JsonProperty("createdDate")
	public String createdDate;
}
