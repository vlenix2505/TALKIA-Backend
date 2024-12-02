package com.upc.talkiaBackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 150)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private Integer year;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "theme", length = 50)
    private String theme;

    @Column(name = "link")
    private String link;


    @Column(name = "i_created_at", updatable = false)
    private LocalDateTime iCreatedAt;

    @Column(name = "i_created_by", length = 150, updatable = false)
    private String iCreatedBy;

    @Column(name = "i_modified_at")
    private LocalDateTime iModifiedAt;

    @Column(name = "i_modified_by", length = 150)
    private String iModifiedBy;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)//LAZZY en session @Transactional
    @JoinTable(
            name = "content_levels",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "levels_id")
    )
    private Set<Level> levels = new HashSet<>();


    @PrePersist
    protected void onCreate() {
        this.iCreatedAt = LocalDateTime.now();
        this.iModifiedAt = LocalDateTime.now();
        this.iCreatedBy = System.getProperty("user.name");
        this.iModifiedBy = System.getProperty("user.name");
    }
    @PreUpdate
    protected void onUpdate() {
        this.iModifiedAt = LocalDateTime.now();
        this.iModifiedBy = System.getProperty("user.name");
    }

}