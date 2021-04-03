package com.qrux.discussion.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private int postId;

	@Column(name = "postDescription")
	private String postDescription;

	@Column(name = "parentId")
	private String parentId;
	
	@Column(name = "createdDate")
	private Timestamp creationDate;

	@Column(name = "lastUpdatedDate")
	private Timestamp lastUpdatedDate;
	
	
	@Column(name = "noOflikes")
	private int noOflikes;
	
	@ManyToOne
	@JoinColumn(name = "createdBy",nullable=false, referencedColumnName = "Contact_Id")
	private MasterContact masterContact;
	
	@ManyToOne
	@JoinColumn(name="topicId",nullable=false,referencedColumnName="topicId")
	private Topic topic;
	
	
	 @Column(name="lastUpdateBy")
    private long lastUpdateBy;
}
