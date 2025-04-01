package com.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.Exception.ResourceNotFoundException;
import com.quiz.entity.QuestionEntity;
import com.quiz.service.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@GetMapping("/allQuestions")
		public List<QuestionEntity> getAllQuestion() {
			return questionService.getAllQuestions();
}
	@GetMapping("/category/{category}") 
	public List<QuestionEntity> getQuestionByCategory(@PathVariable String category) throws ResourceNotFoundException{
		return questionService.getQuestionByCategory(category);
	}
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionEntity question) {
		
		return questionService.addQuestion(question);
	}
	@DeleteMapping("/delete/{id}")
	
		public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id){
			return questionService.deleteQuestionById(id);
	}
	
}
