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
public class HistoryByObjectDTO {
    private String varName1;
    private int id;
    private int userId;
    private LocalDate startDate;
    private Double amount;

}
