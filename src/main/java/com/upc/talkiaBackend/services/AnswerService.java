package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiaBackend.entities.Answer;

import java.util.List;

public interface AnswerService {
    public Answer insertAnswer(Answer answer);
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(int questionId);
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId);
    public Answer updateAnswer(Answer answer);
    public void deleteAnswer(int id);
    public Answer getCorrectAnswerByQuestionId(int questionId);

}
