package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.PaymentTypeDTO;
import com.upc.talkiaBackend.entities.PaymentType;
import com.upc.talkiaBackend.services.PaymentTypeService;
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
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    ModelMapper modelMapper = new ModelMapper();


    @GetMapping("/paymentsType")
    public List<PaymentTypeDTO> listPaymentTypes(){
        List<PaymentType> list = paymentTypeService.listPaymentTypes();
        List<PaymentTypeDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }

}