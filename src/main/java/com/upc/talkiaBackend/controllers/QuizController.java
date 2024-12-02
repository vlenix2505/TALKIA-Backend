package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.QuizDTO;
import com.upc.talkiaBackend.dtos.queries.AveragePointsLevelDTO;
import com.upc.talkiaBackend.dtos.queries.QuizzesPerLevelDTO;
import com.upc.talkiaBackend.entities.Quiz;
import com.upc.talkiaBackend.services.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class QuizController {
    @Autowired
    private QuizService quizService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/quizzes")
    @PreAuthorize("hasRole('ADMIN')")
    public List<QuizDTO> listQuizzes() {
        List<Quiz> quizzes = quizService.listQuizzes();
        List<QuizDTO> quizDTOs = modelMapper.map(quizzes, List.class);
        return quizDTOs;
    }

    @GetMapping("/quiz/id/{quizId}")
    public Quiz getQuizById(@PathVariable int quizId) {
        return quizService.getQuizById(quizId);
    }

    @PostMapping("/quiz/{userId}")
    public Quiz insertQuiz(@PathVariable int userId) {
        return quizService.insertQuiz(userId);
    }

    @GetMapping("/quizzes/{userId}")
    public List<Quiz> listQuizzesByUserId(@PathVariable int userId) {
        return quizService.listQuizzesByUserId(userId);
    }

    @GetMapping("/quizzes/username/{userName}")
    public List<Quiz> listQuizzesByUser(@PathVariable String userName) {
        return quizService.listQuizzesByUser(userName);
    }

    @GetMapping("/quizzes/average")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AveragePointsLevelDTO> listAveragePoints(){
        return quizService.listAveragePoints();
    }

    @GetMapping("/quizzes/quantity")
    @PreAuthorize("hasRole('ADMIN')")
    public List<QuizzesPerLevelDTO> listQuizzesPerLevel(){
        return quizService.listQuizzesPerLevel();
    }
}
