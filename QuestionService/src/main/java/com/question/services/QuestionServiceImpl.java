package com.question.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQues(Question ques) {
       return questionRepo.save(ques);
    }

    @Override
    public List<Question> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public Question getQues(Long quesId) {
        return questionRepo.findById(quesId).orElseThrow(() -> new RuntimeException("No such question here baby"));
    }

    @Override
    public List<Question> getByQuizId(Long quizId) {
       List<Question> byQuizId = this.questionRepo.findByQuizId(quizId);
        return byQuizId;
    }

    

}
