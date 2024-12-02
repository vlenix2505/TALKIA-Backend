package com.upc.talkiaBackend.dtos.queries;

import com.upc.talkiaBackend.entities.Question;
import com.upc.talkiaBackend.entities.Quiz;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class QuizzesQuestionCompleteDTO {
    Integer qqId;
    Question question;
    Quiz quiz;
    Integer attempt;
    String correctAnswer;
    Boolean is_correct;

}
