package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AlternativePublisherName;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AlternativePublisherNameMapper {
    AlternativePublisherName getByAlternativePublisherId(Long alternativePublisherId);
    List<AlternativePublisherName> getByOriginalPublisherId(Long originalPublisherId);
    int insert(AlternativePublisherName alternativePublisherName);
    int update(AlternativePublisherName alternativePublisherName);
    int delete(Long alternativePublisherId);
}
