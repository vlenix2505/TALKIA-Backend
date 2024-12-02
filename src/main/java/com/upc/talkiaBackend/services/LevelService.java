package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.entities.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelService {
    public List<Level> listLevels();
    public Level findById(int levelId);

}
