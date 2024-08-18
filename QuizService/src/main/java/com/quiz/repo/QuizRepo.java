package com.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

}
