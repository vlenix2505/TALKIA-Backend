package com.upc.talkiaBackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowContentByIdDTO {
    private String title;
    private String theme;
    private String description;
    private Integer year;
    private String type;
    private String link;
}
