package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublicationArtist {
    private  Long publicationId;
    private  Long artistId;
}