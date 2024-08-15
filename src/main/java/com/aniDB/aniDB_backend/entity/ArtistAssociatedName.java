package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArtistAssociatedName {
    private Long associatedNameId;
    private Long artistId;
    private String associatedName;
}
