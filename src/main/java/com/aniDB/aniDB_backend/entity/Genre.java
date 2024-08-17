package com.aniDB.aniDB_backend.entity;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Genre {
    private Long genreId;
    private String genreName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}