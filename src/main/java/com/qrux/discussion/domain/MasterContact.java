package com.qrux.discussion.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Master_Contact")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class MasterContact {
	
	@Id
	@Column(name= "Contact_Id")
	private long contactId;
	
	@Column(name= "Contact_First_Display_Name")
	private String contactFirstDisplayName;
	
	@Column(name= "Contact_Last_Display_Name")
	private String contactLastDisplayName;
	
	

}
