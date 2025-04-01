package com.quiz.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.Exception.ResourceNotFoundException;
import com.quiz.entity.QuestionEntity;
import com.quiz.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	public List<QuestionEntity> getAllQuestions() {
		
		return questionRepository.findAll();
	}
	
	public List<QuestionEntity>  getQuestionByCategory(String category) throws ResourceNotFoundException {
		List<QuestionEntity>  cate =questionRepository.findByCategory(category);
		 
		 if (cate.isEmpty()) { 
		   throw new  ResourceNotFoundException("Category not found for given name:" +category);
		 }
		 return cate;
	}

	public ResponseEntity<String>  addQuestion(QuestionEntity question) {
		QuestionEntity addedquestion= questionRepository.save(question);
		return new ResponseEntity<>("Question Added successfully. Question Id:"+ addedquestion.getId(),HttpStatus.CREATED );
	}

	public ResponseEntity<String>  deleteQuestionById(Integer id) {
		QuestionEntity userresponse =questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not found:"+id));
		questionRepository.delete(userresponse);
		return ResponseEntity.ok().build();
	}

}
