package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiaBackend.entities.Level;
import com.upc.talkiaBackend.entities.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    public Question insertQuestion(Question question);
    List<Question> getQuestionsByLevel(Level level);
    public Question updateQuestion(Question question);
    public List<Question> listQuestions();
    List<ShowQuestionByLevelDTO> listQuestionsByLevel(String level);
    public void deleteQuestion(int questionId);
    public Question getQuestionByDescription(String description);
    List<Question> getQuestionsByDescriptionContainingIgnoreCase(String description);
    public Question getQuestionById(int questionId);

}
