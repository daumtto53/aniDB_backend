package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Publisher {
    private  Long publisherId;
    private  String publisherName;
    private  String websiteUrl;
    private  Long parentPublisher;
    private  List<String> alternativePublisherNameList;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}