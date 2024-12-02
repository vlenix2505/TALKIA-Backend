package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.ResponseQqDTO;
import com.upc.talkiaBackend.dtos.queries.QuizzesQuestionCompleteDTO;
import com.upc.talkiaBackend.dtos.queries.ShowQuestionsByQuizDTO;
import com.upc.talkiaBackend.entities.QuizzesQuestion;
import com.upc.talkiaBackend.services.QuizzesQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class QuizzesQuestionController {
    @Autowired
    private QuizzesQuestionService qqService;

    @GetMapping("quizzesQuestion/listTotalQuizzesCompleted/{userId}")
    public Long getTotalQuizzesCompleted(@PathVariable int userId) {
        return qqService.getTotalQuizzesCompleted(userId);
    }
    @GetMapping("quizzesQuestion/correctAnswerPercentage/{userId}")
    public Double getAverageCorrectAnswers(@PathVariable int userId){
        return qqService.getAverageCorrectAnswers(userId);
    }
    @GetMapping("quizzesQuestion/getAvgPointsByLevel/{levelId}")
    public Double getAveragePointsTotal(@PathVariable int levelId){
        return qqService.getAveragePointsTotal(levelId);
    }

    @PutMapping("/quizzesQuestion/answerQuestion/{qqId}/{userAnswer}")
    public ResponseQqDTO answerQuestion(@PathVariable int qqId, @PathVariable String userAnswer){
        ResponseQqDTO responseQqDTO = new ResponseQqDTO();
        responseQqDTO.setMessage(qqService.answerQuestion(qqId, userAnswer));
        return responseQqDTO;
    }

    @GetMapping("/quizzesQuestion/getTotalPoints/{userId}")
    public Double getTotalPoints(@PathVariable int userId){
        return qqService.getTotalPoints(userId);
    }

    @GetMapping("quizzesQuestion/getSecondAttemptCorrect/{quizId}")
    public Integer getSecondAttemptCorrectAnswers(@PathVariable int quizId){
        return qqService.getSecondAttemptCorrectAnswers(quizId);
    }

    @GetMapping("quizzesQuestion/getTotalQuizzesPerLevel/{levelId}")
    public Long getTotalQuizzesCompletedGeneral(@PathVariable int levelId){
        return qqService.getTotalQuizzesCompletedGeneral(levelId);
    }

    @GetMapping("quizzesQuestion/getCorrectAnswersCount/{quizId}")
    public Integer getCorrectAnswersCount(@PathVariable int quizId){
        return qqService.getCorrectAnswersCount(quizId);
    }

    @GetMapping("quizzesQuestion/getPercentageCorrectAnswers/{quizId}")
    public Double getPercentageCorrectAnswers(@PathVariable int quizId){
        return qqService.getPercentageCorrectAnswers(quizId);
    }
    @GetMapping("quizzesQuestion/listQuizzesQuestionByQuizId/{quizId}")
    public List<QuizzesQuestionCompleteDTO> listQuizzesQuestionByQuizId(@PathVariable int quizId) {
        return qqService.listQuizzesQuestionByQuizId(quizId);
    }
    @GetMapping("quizzesQuestion/avgPointsByUser/{userId}")
    public Double getAveragePoints(@PathVariable int userId) {
        return qqService.getAveragePoints(userId);
    }

    @GetMapping("quizzesQuestion/listQuestionsByQuiz/{quizId}")
    public List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(@PathVariable int quizId){
        return qqService.listQuestionsByQuizId(quizId);
    }

}