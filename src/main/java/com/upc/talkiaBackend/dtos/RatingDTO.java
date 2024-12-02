package com.upc.talkiaBackend.dtos;

import com.upc.talkiaBackend.entities.Content;

import com.upc.talkiaBackend.security.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RatingDTO {
    private Integer id;
    private LocalDateTime iRatedAt;
    private Integer score;
    private User user;
    private Content content;
}