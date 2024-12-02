package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiaBackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiaBackend.entities.Payment;

import java.util.List;

public interface PaymentService {
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(Integer userId);
    public List<HistoryByObjectDTO> listPaymentsByYear(Integer userId, Integer year);
    public List<Payment> listPayments();

}
