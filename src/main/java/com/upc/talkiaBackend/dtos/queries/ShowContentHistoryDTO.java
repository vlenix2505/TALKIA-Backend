package com.upc.talkiaBackend.dtos.queries;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowContentHistoryDTO {
    private String name;
    private String content;
    private LocalDateTime iViewedAt;

}
