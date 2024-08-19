package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.PublicationPublisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublicationPublisherMapper {
    PublicationPublisher getByIds(@Param("publicationId") Long publicationId, @Param("publisherId") Long publisherId);
    List<PublicationPublisher> getByPublicationId(Long publicationId);
    int insert(PublicationPublisher publicationPublisher);
    int delete(@Param("publicationId") Long publicationId, @Param("publisherId") Long publisherId);
}