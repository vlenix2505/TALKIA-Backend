package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiaBackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiaBackend.entities.Payment;
import com.upc.talkiaBackend.repositories.PaymentRepository;
import com.upc.talkiaBackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(Integer userId) {
        return paymentRepository.listPaymentsByUser(userId);
    }

    @Override
    public List<HistoryByObjectDTO> listPaymentsByYear(Integer userId, Integer year) {
        return paymentRepository.listPaymentsByYear(userId, year);
    }
    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

}
