package com.question.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/ques")
public class QuesController {

    @Autowired
    private QuestionService questionService;


    //create

    @PostMapping
    public ResponseEntity<Question> createQues(@RequestBody Question question){

        Question ques = questionService.addQues(question);

        return ResponseEntity.status(HttpStatus.CREATED).body(ques);
    }


    //find all


    @GetMapping
    public ResponseEntity<List<Question>> getAllQues(){

        List<Question> allQues = questionService.getAll();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allQues);
    }

@GetMapping("/{quesId}")
    public ResponseEntity<Question> getAQues(@PathVariable("quesId") Long quesId){

        Question ques = questionService.getQues(quesId);

        return ResponseEntity.status(HttpStatus.FOUND).body(ques);

        
    }


    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> findbYquizId(@PathVariable ("quizId") Long quizId){
List<Question> byQuizId = this.questionService.getByQuizId(quizId);

return ResponseEntity.status(HttpStatus.OK).body(byQuizId);

    }

}
