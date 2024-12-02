package com.upc.talkiaBackend.entities;

import com.upc.talkiaBackend.security.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quizzes_id", nullable = false)
    private Integer id;

    private Double totalPoints;

    @Column(name = "i_created_at", updatable = false)
    private LocalDateTime iCreatedAt;

    @PrePersist
    protected void onCreate() {
        iCreatedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
}