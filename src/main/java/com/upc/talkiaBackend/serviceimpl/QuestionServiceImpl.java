package com.upc.talkiaBackend.serviceimpl;


import com.upc.talkiaBackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiaBackend.entities.Level;
import com.upc.talkiaBackend.entities.Question;
import com.upc.talkiaBackend.repositories.QuestionRepository;
import com.upc.talkiaBackend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    @Transactional
    public Question insertQuestion(Question question) {
        return questionRepository.save(question);
    }
    @Override
    @Transactional
    public Question updateQuestion(Question question) {
        if(questionRepository.existsById(question.getId())) {
            return questionRepository.save(question);
        }
        return null;
    }
    @Override
    public Question getQuestionByDescription(String description){
        return questionRepository.getQuestionByDescription(description);
    }
    @Override
    @Transactional
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<Question> getQuestionsByLevel(Level level){
        return questionRepository.getQuestionsByLevel(level);
    }

    @Override
    public List<Question> listQuestions(){
        return questionRepository.findAll();
    }
    @Override
    public List<ShowQuestionByLevelDTO> listQuestionsByLevel(String level) {
        return questionRepository.listQuestionsByLevel(level);
    }
    @Override
    public Question getQuestionById(int id){
        if(questionRepository.existsById(id)){
            return questionRepository.findById(id).get();
        }
        return null;
    }
    @Override
    public List<Question> getQuestionsByDescriptionContainingIgnoreCase(String description) {
        return questionRepository.getQuestionsByDescriptionContainingIgnoreCase(description);
    }
}
