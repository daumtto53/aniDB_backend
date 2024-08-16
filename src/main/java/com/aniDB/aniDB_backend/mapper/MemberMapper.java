package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MemberMapper {

    void insertMember(Member member);

    void insertMemberNecessary(Member member);

    Member selectMemberById(Long memberId);

    void updateMember(Member member);

    int deleteMember(int memberId);

    List<Member> selectAllMembers();
}