package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.QuestionDTO;
import com.upc.talkiaBackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiaBackend.entities.Question;
import com.upc.talkiaBackend.services.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    ModelMapper modelMapper = new ModelMapper();
    @GetMapping("/question/description/{description}")
    public Question getQuestionByDescription(@PathVariable String description) {
        return questionService.getQuestionByDescription(description);
    }

    @PutMapping("/question")
    @PreAuthorize("hasRole('ADMIN')")
    public QuestionDTO updateQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = modelMapper.map(questionDTO, Question.class);
        question = questionService.updateQuestion(question);
        return modelMapper.map(question, QuestionDTO.class);
    }

    @PostMapping("/question")
    @PreAuthorize("hasRole('ADMIN')")
    public QuestionDTO insertQuestion(@RequestBody QuestionDTO questionDTO){
        Question question = modelMapper.map(questionDTO, Question.class);
        question = questionService.insertQuestion(question);
        return modelMapper.map(question, QuestionDTO.class);
    }

    @GetMapping("/questions/description/{description}")
    public List<QuestionDTO> getQuestionsByDescriptionContaining(@PathVariable String description) {
        List<Question>list = questionService.getQuestionsByDescriptionContainingIgnoreCase(description);
        List<QuestionDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }

    @GetMapping("/questions")
    @PreAuthorize("hasRole('ADMIN')")
    public List<QuestionDTO> listQuestions(){
        List<Question>list = questionService.listQuestions();
        List<QuestionDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
    @GetMapping("/level/{level}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ShowQuestionByLevelDTO>listQuestionsByLevel(@PathVariable String level){
        return questionService.listQuestionsByLevel(level);
    }
    @DeleteMapping("/question/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
    }
    @GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

}