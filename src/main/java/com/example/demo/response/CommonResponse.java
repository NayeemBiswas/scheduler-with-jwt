package com.example.demo.response;

import java.io.Serializable;


import lombok.Data;


@Data
public class CommonResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private boolean status;
	
	private String message;
	
	private String messageBn;
	
	private Object data;
	
	
	
	
}
