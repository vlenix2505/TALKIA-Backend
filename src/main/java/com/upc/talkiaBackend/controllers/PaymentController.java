package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.PaymentDTO;
import com.upc.talkiaBackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiaBackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiaBackend.entities.Payment;
import com.upc.talkiaBackend.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class PaymentController{

    @Autowired
    private PaymentService paymentService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/paymentsbyyear/{userId}")
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(@PathVariable Integer userId){
        return paymentService.listPaymentsByUser(userId);
    }
    @GetMapping("/paymentbyyear/{userId}/{year}")
    @PreAuthorize("hasRole('USER')")
    public List<HistoryByObjectDTO>listPaymentsByYear(@PathVariable Integer userId, @PathVariable Integer year) {
        return paymentService.listPaymentsByYear(userId, year);
    }
    @GetMapping("/payments")
    public List<PaymentDTO> listPayments(){
        List<Payment> list = paymentService.listPayments();
        List<PaymentDTO> listDTO = modelMapper.map(list, List.class);
        return listDTO;
    }
}