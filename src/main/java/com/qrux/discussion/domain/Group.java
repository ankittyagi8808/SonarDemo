package com.qrux.discussion.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="[Groups]")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Group implements Serializable {
	
	private static final long serialVersionUID = -8757448075584686829L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="groupId")
	private int groupId;
	
	@Column(name="groupDescription")
	private String groupDescription;
	
	@Column(name="groupType")
    private String groupType;
	
	@Column(name="createdDate")
	private Timestamp createdDate;
	
	@Column(name="createdBy")
	private int createdBy;

	 @OneToMany(mappedBy = "group")
	 private Set<Categories> categories;
}

