package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.entity.UpvotedPublication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UpvotedPublicationMapper {

    List<UpvotedPublication> selectUpvotedPublicationByMemberId(Long memberId);

    List<UpvotedPublication> selectUpvotedPublicationByPublicationId(Long publicationId);

    int insertUpvotedPublication(UpvotedPublication upvotedPublication);

    int updateUpvotedPublication(UpvotedPublication upvotedPublication);

    int deleteUpvotedPublication(UpvotedPublication upvotedPublication);
}