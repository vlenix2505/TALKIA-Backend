package com.upc.talkiaBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questions_id", nullable = false)
    private Integer id;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "feedback", length = Integer.MAX_VALUE)
    private String feedback;

    @Column(name = "i_created_at", updatable = false)
    private LocalDateTime iCreatedAt;

    @Column(name = "i_created_by", length = 150, updatable = false)
    private String iCreatedBy;

    @Column(name = "i_modified_at")
    private LocalDateTime iModifiedAt;

    @Column(name = "i_modified_by", length = 150)
    private String iModifiedBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "levels_id")
    private Level level;

    @PrePersist
    protected void onCreate() {
        iCreatedAt =  LocalDateTime.now();
        iModifiedAt= LocalDateTime.now();
        iCreatedBy=System.getProperty("user.name");
        iModifiedBy = System.getProperty("user.name");
    }
    @PreUpdate
    protected void onUpdate() {
        iModifiedAt =  LocalDateTime.now();
        iModifiedBy = System.getProperty("user.name");
    }
}