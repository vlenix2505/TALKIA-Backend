package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.AveragePointsLevelDTO;
import com.upc.talkiaBackend.dtos.queries.QuizzesPerLevelDTO;
import com.upc.talkiaBackend.entities.Quiz;

import java.util.List;

public interface QuizService {
    public List<Quiz> listQuizzes();
    public Quiz insertQuiz(int userId);
    public List<Quiz> listQuizzesByUserId(int userId);
    public List<AveragePointsLevelDTO> listAveragePoints();
    public List<QuizzesPerLevelDTO> listQuizzesPerLevel();
    public List<Quiz> listQuizzesByUser( String userName);
    public Quiz getQuizById(int quizId);


}

