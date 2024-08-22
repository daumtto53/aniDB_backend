package com.aniDB.aniDB_backend.dto.entity.alternative_title;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlternativeTitleDTO {
    private String alternativeTitle;
    private String language;
}


