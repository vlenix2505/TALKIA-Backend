package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
public class AveragePointsLevelDTO {
    private Double averagePointsLevel;
    private String levelName;
}
