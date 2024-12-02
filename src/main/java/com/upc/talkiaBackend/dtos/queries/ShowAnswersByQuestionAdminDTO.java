package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowAnswersByQuestionAdminDTO {
    private Integer id;
    private String answersDescription;
    private boolean isCorrect;

}
