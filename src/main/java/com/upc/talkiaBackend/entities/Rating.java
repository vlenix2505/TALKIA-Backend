package com.upc.talkiaBackend.entities;

import com.upc.talkiaBackend.security.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratings_id", nullable = false)
    private Integer id;

    @Column(name = "i_rated_at", updatable = false)
    private LocalDateTime iRatedAt;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Content.class)
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @PrePersist
    protected void onCreate() {
        iRatedAt = LocalDateTime.now();
    }
}