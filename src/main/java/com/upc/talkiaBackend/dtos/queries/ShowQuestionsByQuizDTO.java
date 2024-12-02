package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ShowQuestionsByQuizDTO {
    private Integer qqId;
    private Integer questionId;
    private String question;
}
