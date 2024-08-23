package com.aniDB.aniDB_backend.dto.entity.publisher;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PublisherDTO {
    private  Long publisherId;
    private  String publisherName;
    private  String websiteUrl;
    //상위 출판사.
    private  Long parentPublisherId;
    private  String parentPublisherName;
    private List<String> alternativePublisherNameList;

    @Builder.Default
    private int descendantPublicationCount = 0;

    // 하위 레이블. 재귀로 가져온다. query 1번 더.
    private List<LabelDTO> labelList;
    // 하위 레이블의 정보를 토대로 출판물 정보를 가져온다. query 한번 더.
    private List<DescendantOfPublisherDTO> descendantPublicationList;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
