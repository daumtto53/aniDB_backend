package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.DescendantOfPublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.LabelDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;

@Mapper
public interface PublisherMapper {
    Publisher getByPublisherId(Long publisherId);
    List<Publisher> getAll();
    int countAll();
    int insert(Publisher publisher);
    int update(Publisher publisher);
    int delete(Long publisherId);
    List<PublisherPageDTO> getPublisherPageDTO(Pageable pageable);
    PublisherDTO getPublisherDTOById(Long publisherId);

    //use this query with getPublisherPageDTO and getPublisherDTOById.
    int getPublicationCountOfPublisherDescendant(Long publisherId);
    List<LabelDTO> getLabelListById(Long publisherId);
    List<DescendantOfPublisherDTO> getLabelPublicationById(List<LabelDTO> list);

}