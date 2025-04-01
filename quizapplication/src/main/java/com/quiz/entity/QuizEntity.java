package com.quiz.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity


public class QuizEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ManyToMany
	private List<QuestionEntity> questions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<QuestionEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}
	public QuizEntity(Integer id, String title, List<QuestionEntity> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questions = questions;
	}
	public QuizEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
