package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

    Question addQues(Question ques);

    List<Question> getAll();

    Question getQues(Long quesId);

    List<Question> getByQuizId(Long quizId);

}
