package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PublisherMapper {
    Publisher getByPublisherId(Long publisherId);
    List<Publisher> getAll();
    int countAll();
    int insert(Publisher publisher);
    int update(Publisher publisher);
    int delete(Long publisherId);
}