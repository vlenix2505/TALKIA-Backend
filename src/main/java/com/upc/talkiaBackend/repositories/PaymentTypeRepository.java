package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
    public PaymentType getPaymentTypeById(int id);


}
