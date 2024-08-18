package com.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    //create

    @Autowired
    private QuizService quizService;


    @PostMapping
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz){


        Quiz createdQuiz = quizService.add(quiz);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuiz(){
List<Quiz> allQuiz = quizService.getAll();

return ResponseEntity.status(HttpStatus.OK).body(allQuiz);
        
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable ("quizId") Long quizId){

Quiz quiz = quizService.get(quizId);
return ResponseEntity.status(HttpStatus.FOUND).body(quiz);
    }




}
