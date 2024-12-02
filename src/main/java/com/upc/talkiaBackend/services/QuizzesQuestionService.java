package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.QuizzesQuestionCompleteDTO;
import com.upc.talkiaBackend.dtos.queries.ShowQuestionsByQuizDTO;

import java.util.List;

public interface QuizzesQuestionService {

    public Double getAveragePoints(int userId);
    public Long getTotalQuizzesCompleted(int userId);
    public Double getTotalPoints(int userId);
    public Double getAverageCorrectAnswers(int userId);
    public void finalizeQuiz(int quizId);
    public Double getAveragePointsTotal(int levelId);
    public Long getTotalQuizzesCompletedGeneral(int levelId);
    public String answerQuestion(int qqId, String userAnswer);
    public Integer getSecondAttemptCorrectAnswers(int quizId);
    public Integer getCorrectAnswersCount(int quizId);
    public Double getPercentageCorrectAnswers(int quizId);
    public List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(int quizId);
    public List<QuizzesQuestionCompleteDTO> listQuizzesQuestionByQuizId(int quizId);

}
