package com.aniDB.aniDB_backend.dto.entity.related_series;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelatedSeriesDTO {
    private String title;
    private String relation;
}