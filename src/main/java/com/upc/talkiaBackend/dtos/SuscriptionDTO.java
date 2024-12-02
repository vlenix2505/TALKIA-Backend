package com.upc.talkiaBackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SuscriptionDTO {

    private Integer id;
    private String name;
    private Double price;
    private Integer durationMonths;
}
