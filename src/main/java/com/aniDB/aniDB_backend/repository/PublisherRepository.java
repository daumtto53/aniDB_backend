package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.publisher.DescendantOfPublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.LabelDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.entity.Publisher;
import com.aniDB.aniDB_backend.mapper.PublisherMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<PublisherPageDTO> getPage(Pageable pageable) {
        List<PublisherPageDTO> publisherPageDTO = publisherMapper.getPublisherPageDTO(pageable);
        publisherPageDTO.stream().forEach(e -> {
            int cnt = publisherMapper.getPublicationCountOfPublisherDescendant(e.getPublisherId());
            e.setDescendantPublicationCount(cnt);
        });
        return publisherPageDTO;
    }

    public PublisherDTO getPublisherDTOById(Long publisherId) {
        PublisherDTO publisherDTO = publisherMapper.getPublisherDTOById(publisherId);
        int cnt = publisherMapper.getPublicationCountOfPublisherDescendant(publisherId);
        List<LabelDTO> labelList = publisherMapper.getLabelListById(publisherId);
        List<DescendantOfPublisherDTO> descendantList = publisherMapper.getLabelPublicationById(labelList);
        publisherDTO.setDescendantPublicationCount(cnt);
        publisherDTO.setLabelList(labelList);
        publisherDTO.setDescendantPublicationList(descendantList);
        return publisherDTO;

    }
}