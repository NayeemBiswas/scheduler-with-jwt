package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "CHANNEL", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"TITLE", "LINK"})
	}) 
public class Channel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name = "TITLE", length = 150)
	private String title;
	
	@Column(name = "TTL" , length = 20)
	private String ttl;
	
	@Column(name = "LINK")
	private String link;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "COPYRIGHT", length = 50)
	private String copyright;
	
	@Column(name = "LANGUAGE", length = 10)
	private String language;
	
	@Column(name = "PUB_DATE")
	private Date pubDate;

}
