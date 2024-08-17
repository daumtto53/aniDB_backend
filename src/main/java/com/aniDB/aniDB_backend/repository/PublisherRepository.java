package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Publisher;
import com.aniDB.aniDB_backend.mapper.PublisherMapper;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublisherRepository {

    private final PublisherMapper publisherMapper;

    public Publisher getById(Long publisherId) {
        return publisherMapper.getByPublisherId(publisherId);
    }

    public List<Publisher> getAll() {
        return publisherMapper.getAll();
    }

    public int create(Publisher publisher) {
        return publisherMapper.insert(publisher);
    }

    public int update(Publisher publisher) {
        return publisherMapper.update(publisher);
    }

    public int delete(Long publisherId) {
        return publisherMapper.delete(publisherId);
    }
}