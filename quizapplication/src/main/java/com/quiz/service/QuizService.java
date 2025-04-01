package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.entity.QuestionEntity;
import com.quiz.entity.QuestionWrapper;
import com.quiz.entity.QuizEntity;
import com.quiz.entity.Response;
import com.quiz.repository.QuestionRepository;
import com.quiz.repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	QuizRepository quizRepository;

	@Autowired
	QuestionRepository questionRepository;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
//		questions obj is created in quizentity and we are calling it here to fetch random questions.
		List<QuestionEntity> questions= questionRepository.findRandomQuestionByCategory(category, numQ);
		QuizEntity quiz =new QuizEntity();
//		setting the title from user.
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepository.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//		storing the question using id in quiz. retriving the quiz
		Optional<QuizEntity> quiz = quizRepository.findById(id);
//		getting the question from quiz which is already has set of qst stored in id  from quizentity. extract the question
		List<QuestionEntity> questionFromDB = quiz.get().getQuestions();
//		creating new memeory. simply getting data from db and storing it in questionwrapper.
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for (QuestionEntity q: questionFromDB ) {
			QuestionWrapper qw= new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		QuizEntity  quiz= quizRepository.findById(id).get(); 
		List<QuestionEntity> questions= quiz.getQuestions();
//		System.out.println(questions);
		int correctAnswer=0;
		int i=0;
		for (Response response: responses)
		{
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
			correctAnswer++;
			i++;
		
		}
		
		
		return new ResponseEntity<>(correctAnswer, HttpStatus.OK);
	}
	
	
}
