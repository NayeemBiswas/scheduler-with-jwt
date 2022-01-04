package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@Data
@Entity
@Table(name = "ITEM", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"CHANNEL_ID", "LINK", "GUID"})
	}) 
public class Item implements Serializable{

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name ="CHANNEL_ID")
	private Channel channel;
	
	@Column(name = "TITLE", length = 150)
	private String title;
	
	@Column(name = "LINK")
	private String link;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "GUID" , length = 200)
	private String guid;
}
