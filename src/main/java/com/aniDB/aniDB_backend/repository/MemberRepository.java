package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final MemberMapper memberMapper;

    @Transactional
    public void save(Member member) {
        memberMapper.insertMember(member);
    }

    @Transactional
    public void saveNecessary(Member member) {
        memberMapper.insertMemberNecessary(member);
    }

    @Transactional
    public Member findById(Long memberId) {
        return memberMapper.selectMemberById(memberId);
    }

    @Transactional
    public void update(Member member) {
        memberMapper.updateMember(member);
    }


    @Transactional
    public int delete(int memberId) {
        return memberMapper.deleteMember(memberId);
    }

    @Transactional
    public List<Member> findAll() {
        return memberMapper.selectAllMembers();
    }
}