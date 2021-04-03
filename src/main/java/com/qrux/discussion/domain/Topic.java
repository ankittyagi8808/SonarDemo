package com.qrux.discussion.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Topic")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Topic  implements Serializable {

	private static final long serialVersionUID = -8737269613661512412L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="topicId")
	public long topicId;
	
	@Column(name="TopicTitle")
	private String topicTitle;
	
	@Column(name="topicDescription",length=1000)
	private String topicDescription;
	
	@Column(name="noOfComments")
	private int noOfComments;
	
	@Column(name="noOfLikes")
	private int noOfLikes;
	
	@Column(name="noOfViews")
	private String noOfViews;
	
	@Column(name="lastUpdateDate")
	private Timestamp lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name = "createdBy",nullable=false, referencedColumnName = "Contact_Id")
	private MasterContact masterContact;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "forumId",nullable=false, referencedColumnName = "forumId")
	private Forum form;
		
	@Column(name="createdDate")
	 private Timestamp createDate;
     
	@OneToMany(mappedBy = "topic")
	private Set<Post> post;

	@Column(name="lastUpdateBy")
    private long lastUpdateBy;
}

