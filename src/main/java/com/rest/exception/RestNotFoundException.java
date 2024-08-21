package com.rest.exception;

public class RestNotFoundException extends RuntimeException{
	
	public RestNotFoundException(String message){
		super(message);
	}
	
}
