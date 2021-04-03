package com.qrux.discussion.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Forum")
public class Forum implements Serializable {

	private static final long serialVersionUID = 3839369655870568074L;

	@Id
	@Column(name = "forumId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int forumId;

	@Column(name = "forumDescription")
	public String forumDescription;

	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false, referencedColumnName = "categoryId")
	private Categories categories;

	@Column(name = "creationDate")
	public Timestamp creationDate;

	
	@Column(name = "lastUpdateDate")
    public Timestamp lastUpdateDate;
	
	@Column(name = "createdBy")
	public int createdBy;
	
	@OneToMany(mappedBy = "form")
	private List<Topic> form = new ArrayList<Topic>();;
}
