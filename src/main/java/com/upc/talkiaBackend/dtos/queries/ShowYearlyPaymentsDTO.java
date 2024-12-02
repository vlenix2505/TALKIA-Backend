package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowYearlyPaymentsDTO {
    private String nameSuscription;
    private Double amount;
    private LocalDateTime date;
}
