package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.entities.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    public List<PaymentType> listPaymentTypes();
    public PaymentType getPaymentTypeById(int id);

}
