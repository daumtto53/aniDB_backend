package com.aniDB.aniDB_backend.dto.entity.publisher;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PublisherPageDTO {
    private Long publisherId;
    private String publisherName;
    private int descendantPublicationCount;
}
