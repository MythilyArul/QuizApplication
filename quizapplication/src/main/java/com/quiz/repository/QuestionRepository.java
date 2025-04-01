package com.quiz.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.entity.QuestionEntity;


@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer>{
//creating a find by category for this:
	List<QuestionEntity>   findByCategory(String category);
	
	@Query(value="SELECT * FROM question q Where q.category=:category ORDER BY RAND() LIMIT 8",nativeQuery =true)                
	List<QuestionEntity> findRandomQuestionByCategory(@Param("category") String category, int numQ);

}
