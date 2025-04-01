package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer>{

}
