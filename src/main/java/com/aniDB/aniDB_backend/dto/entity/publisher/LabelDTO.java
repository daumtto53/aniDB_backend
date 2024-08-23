package com.aniDB.aniDB_backend.dto.entity.publisher;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LabelDTO {
    private Long publisherId;
    private String publisherName;
}
