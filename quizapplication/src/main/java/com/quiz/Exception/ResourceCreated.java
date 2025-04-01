package com.quiz.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.CREATED)
public class ResourceCreated extends RuntimeException{

	public ResourceCreated(String message) {
		super(message);
		
	}
 
}
