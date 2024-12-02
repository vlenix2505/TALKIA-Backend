package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.SuscriptionDTO;
import com.upc.talkiaBackend.entities.Suscription;
import com.upc.talkiaBackend.services.SuscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class SuscriptionController {

    @Autowired
    private SuscriptionService suscriptionService;
    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/suscription")
    public List<SuscriptionDTO> listSuscription(){
        List<Suscription> suscriptions = suscriptionService.listSuscriptions();
        List<SuscriptionDTO> suscriptionDTOs = modelMapper.map(suscriptions, List.class);
        return suscriptionDTOs;
    }
}