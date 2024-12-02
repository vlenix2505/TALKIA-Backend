package com.upc.talkiaBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "levels_id", nullable = false)
    private Integer id;

    @Column(name = "level", length = 12)
    private String level;

}