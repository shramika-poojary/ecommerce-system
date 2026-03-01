package com.data.exception;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResourceNotFoundException extends RuntimeException{

	private String message;


	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [message=" + message + "]";
	}


	

	
	
	
}
