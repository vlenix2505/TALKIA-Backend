package com.upc.talkiaBackend.repositories;

import com.upc.talkiaBackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiaBackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiaBackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("select new com.upc.talkiaBackend.dtos.queries.ShowYearlyPaymentsDTO(s.name, p.amount, p.date) from Payment p JOIN SuscriptionsHistory sh on p.id=sh.payment.id " +
        "JOIN User u on sh.user.id=u.id " +
        "JOIN Suscription s on sh.suscription.id=s.id WHERE u.id = :userId")
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(@Param("userId") Integer user);

    @Query("select new com.upc.talkiaBackend.dtos.queries.HistoryByObjectDTO(sh.suscription.name,sh.id, sh.user.id, sh.startDate,sh.payment.amount) FROM " +
            "SuscriptionsHistory sh where sh.user.id = :userId AND Year(sh.startDate)=:year order by sh.id desc")
    public List<HistoryByObjectDTO>listPaymentsByYear(@Param("userId") Integer user, @Param("year") Integer year);
}

