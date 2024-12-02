package com.upc.talkiaBackend.controllers;
import com.upc.talkiaBackend.dtos.LevelDTO;
import com.upc.talkiaBackend.entities.Level;
import com.upc.talkiaBackend.services.LevelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class LevelController {

    @Autowired
    private LevelService levelService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/levels")
    public List<LevelDTO> listLevels(){
        List<Level> levels=levelService.listLevels();
        List<LevelDTO> levelsDTO =modelMapper.map(levels, List.class);
        return levelsDTO;
    }
    @GetMapping("/levelId/{levelId}")
    public Level findById(@PathVariable int levelId){
        return levelService.findById(levelId);
    }
}