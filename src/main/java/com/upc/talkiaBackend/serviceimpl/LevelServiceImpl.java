package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.entities.Level;
import com.upc.talkiaBackend.repositories.LevelRepository;
import com.upc.talkiaBackend.services.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;
    @Override
    public List<Level> listLevels() {
        return levelRepository.findAll();
    }

    @Override
    public Level findById(int levelId) {
        return levelRepository.findById(levelId);
    }
}
