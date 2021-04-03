package com.qrux.discussion.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = -9071311779640060544L;
    @Id
	@Column(name ="userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	@Column(name="userName")
    private String userName;

}
