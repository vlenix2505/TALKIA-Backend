package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryByUserPaymentDTO {
    private Double amount;
    private String paymentTypeName;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}

