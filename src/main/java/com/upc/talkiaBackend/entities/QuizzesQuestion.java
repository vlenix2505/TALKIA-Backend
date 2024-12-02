package com.upc.talkiaBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "quizzes_questions")
public class QuizzesQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizzes_questions_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quizzes_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questions_id")
    private Question question;

    @Column(name = "user_answer")
    private String userAnswer;

    @Column(name = "points_earned")
    private Double pointsEarned;

    @Column(name = "attempt")
    private Integer attempt;

    @Column(name = "i_attempt_at", updatable = false)
    private LocalDateTime iAttemptAt;

    private Boolean is_correct;

    @PrePersist
    protected void onCreate() {
        iAttemptAt = LocalDateTime.now();
    }
}