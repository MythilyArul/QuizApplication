package com.quiz.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class ResponEntity {
	private Integer id;
	private String response;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public ResponEntity(Integer id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	
	
}
