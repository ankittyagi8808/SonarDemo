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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForumDto {
    @JsonProperty("forumId")
	public int forumId;
    @JsonProperty("forumDescription")
	public String forumDescription;
    @JsonProperty("categoryId")
	public int categoryId;
    @JsonProperty("creationDate")
	public String creationDate;
    @JsonProperty("lastUpdateDate")
	public String lastUpdateDate;
    @JsonProperty("createdBy")
    public int createdBy;
	@JsonProperty("categories")
	CategoryDto categories;
}
