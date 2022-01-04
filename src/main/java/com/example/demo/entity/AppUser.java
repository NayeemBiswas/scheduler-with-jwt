package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;


@Data
@Entity
@Table(name = "APP_USER")
public class AppUser implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name = "ACTIVE", columnDefinition = "boolean default true")
	private Boolean active = true;

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(AppUser.class);
	
	@Column(name = "USERNAME", length=50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "EMAIL", length=100)
	private String email;
	
	@Column(name = "MOBILE", length=20)
	private String mobile;


	@Column(name = "IS_ACCOUNT_EXPIRED", columnDefinition = "boolean default false")
	private Boolean accountExpired = false;

	@Column(name = "IS_CREDENTIALS_EXPIRED", columnDefinition = "boolean default false")
	private Boolean credentialsExpired = false;

	@Column(name = "IS_ACCOUNT_LOCKED", columnDefinition = "boolean default false")
	private Boolean accountLocked = false;
	
	
}
