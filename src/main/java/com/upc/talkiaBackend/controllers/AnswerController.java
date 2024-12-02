package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.AnswerDTO;
import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiaBackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiaBackend.entities.Answer;
import com.upc.talkiaBackend.services.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("/api")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    ModelMapper modelMapper = new ModelMapper();

    @DeleteMapping("/answer/{id}")
    public void deleteAnswer(@PathVariable int id){
        answerService.deleteAnswer(id);
    }

    @PostMapping("/answer")
    public AnswerDTO insertAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer=answerService.insertAnswer(answer);
        return modelMapper.map(answer,AnswerDTO.class);
    }

    @GetMapping("/correctAnswerByQuestionId/{questionId}")
    public Answer getCorrectAnswerByQuestionId(@PathVariable int questionId) {
        return answerService.getCorrectAnswerByQuestionId(questionId);
    }

    @GetMapping("/answers/listAnswersByQuestionAdmin/{questionId}")
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(@PathVariable int questionId) {
        return answerService.listAnswerByQuestionAdmin(questionId);
    }

    @GetMapping("/answers/listAnswersByQuestionUser/{questionId}")
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(@PathVariable int questionId) {
        return answerService.listAnswerByQuestionUser(questionId);
    }
    @PutMapping("/answer")
    public AnswerDTO updateAnswer(@RequestBody AnswerDTO answerDTO){
        Answer answer = modelMapper.map(answerDTO, Answer.class);
        answer=answerService.updateAnswer(answer);
        return modelMapper.map(answer,AnswerDTO.class);

    }

}
