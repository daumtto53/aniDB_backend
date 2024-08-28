package com.aniDB.aniDB_backend.dto.search;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDTO {
    String typeString;
    String option;
    String searchQuery;
}
