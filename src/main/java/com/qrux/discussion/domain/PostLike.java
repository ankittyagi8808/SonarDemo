package com.qrux.discussion.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PostLike")
public class PostLike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likeId")
	private Long likeId;

	@Column(name = "postId")
	private Long postId;

	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "topicId")
	private Long topicId;
}
