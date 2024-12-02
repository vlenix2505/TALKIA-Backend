package com.upc.talkiaBackend.dtos;

import com.upc.talkiaBackend.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class QuestionDTO {
    private Integer id;
    private String description;
    private String feedback;
    private LocalDateTime iCreatedAt;
    private String iCreatedBy;
    private LocalDateTime iModifiedAt;
    private String iModifiedBy;
    private Level level;
}
