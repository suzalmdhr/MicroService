package com.quiz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

@Service
@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionClient {


    @GetMapping("/ques/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId);



}
