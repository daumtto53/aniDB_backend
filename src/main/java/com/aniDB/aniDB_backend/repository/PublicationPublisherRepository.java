package com.aniDB.aniDB_backend.repository;


import com.aniDB.aniDB_backend.entity.PublicationPublisher;
import com.aniDB.aniDB_backend.mapper.PublicationPublisherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublicationPublisherRepository {

    private final PublicationPublisherMapper publicationPublisherMapper;

    public PublicationPublisher getByIds(Long publicationId, Long publisherId) {
        return publicationPublisherMapper.getByIds(publicationId, publisherId);
    }

    public List<PublicationPublisher> getByPublicationId(Long publicationId) {
        return publicationPublisherMapper.getByPublicationId(publicationId);
    }

    public int create(PublicationPublisher publicationPublisher) {
        return publicationPublisherMapper.insert(publicationPublisher);
    }

    public int delete(Long publicationId, Long publisherId) {
        return publicationPublisherMapper.delete(publicationId, publisherId);
    }
}