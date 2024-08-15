package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SeriesType {
    private Long typeId;
    private String typeName;
}
