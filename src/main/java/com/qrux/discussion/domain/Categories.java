package com.qrux.discussion.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "Category")
public class Categories {

	@Id
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int categoryId;

	@Column(name = "categoryDescription")
	public String catDescription;
	
	@Column(name = "createdBy")
	private int createdBy;
	
	@Column(name = "creationDate")
	private Timestamp creationDate;

	@Column(name = "lastUpdateDate")
	private Timestamp lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name = "groupId", nullable = false, referencedColumnName = "groupId")
	private Group group;

	@OneToMany(mappedBy = "categories")
	private Set<Forum> forum;

}
