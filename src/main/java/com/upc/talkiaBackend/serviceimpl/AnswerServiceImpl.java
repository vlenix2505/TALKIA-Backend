package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiaBackend.entities.Answer;
import com.upc.talkiaBackend.repositories.AnswerRepository;
import com.upc.talkiaBackend.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    public AnswerRepository answerRepository;
    @Override
    public Answer insertAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    @Override
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(int questionId) {
        return answerRepository.listAnswerByQuestionAdmin(questionId);
    }

    @Override
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId) {
        return answerRepository.listAnswerByQuestionUser(questionId);
    }
    @Override
    public Answer updateAnswer(Answer answer){
        if(answerRepository.existsById(answer.getId())){
            return answerRepository.save(answer);
        }
        return null;
    }

    @Override
    public void deleteAnswer(int id){
        if(answerRepository.existsById(id)){
            answerRepository.deleteById(id);
        }
    }

    @Override
    public Answer getCorrectAnswerByQuestionId(int questionId) {
        return answerRepository.getCorrectAnswerByQuestionId(questionId);
    }


}
