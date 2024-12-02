package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    public Level findById(int levelId);
}
