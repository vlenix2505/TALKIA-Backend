package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.entities.PaymentType;
import com.upc.talkiaBackend.repositories.PaymentTypeRepository;
import com.upc.talkiaBackend.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> listPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getPaymentTypeById(int id) {
        return paymentTypeRepository.findById(id).get();
    }
}
