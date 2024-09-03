package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.UpvotedPublication;
import com.aniDB.aniDB_backend.mapper.UpvotedPublicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UpvotedPublicationRepository {
    private final UpvotedPublicationMapper upvotedPublicationMapper;

    public List<UpvotedPublication> findByMemberId(Long memberId) {
        return upvotedPublicationMapper.selectUpvotedPublicationByMemberId(memberId);
    }

    public List<UpvotedPublication> findByPublicationId(Long publicationId) {
        return upvotedPublicationMapper.selectUpvotedPublicationByPublicationId(publicationId);
    }

    public UpvotedPublication find(Long memberId, Long publicationId) {
        return upvotedPublicationMapper.selectUpvotedPublication(memberId, publicationId);
    }

    public void save(UpvotedPublication upvotedPublication) {
            upvotedPublicationMapper.insertUpvotedPublication(upvotedPublication);
    }

    public void delete(UpvotedPublication upvotedPublication) {
        upvotedPublicationMapper.deleteUpvotedPublication(upvotedPublication);
    }
}
