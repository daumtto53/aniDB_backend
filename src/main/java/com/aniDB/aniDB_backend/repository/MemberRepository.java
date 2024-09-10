package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public Member findByUsername(String username) { return memberMapper.selectMemberByUsername(username); }

    @Transactional
    public Member findByLoginId(String loginId) {return memberMapper.selectMemberByLoginId(loginId);}

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
//        List<Map<String, Objects>> maps = memberMapper.selectAllMembers();
//        List<Member> memberList = maps.stream().map(
//                m -> {
//                    Long l = Long.valueOf(String.valueOf(m.get("member_id")));
//                    Member member = Member.builder()
//                            .memberId(l)
//                            .username(String.valueOf(m.get("username")))
//                            .loginId(String.valueOf(m.get("loginid")))
//                            .password(String.valueOf(m.get("member_password")))
//                            .email(String.valueOf(m.get("email"))) // Assuming 'email' exists in the map
//                            .isFromSocial(Boolean.parseBoolean(String.valueOf(m.get("isFromSocial"))))
//                            .isDisabled(Boolean.parseBoolean(String.valueOf(m.get("isDisabled"))))
//                            .name(String.valueOf(m.get("name")))
//                            .nickname(String.valueOf(m.get("nickname")))
//                            .birthday(LocalDateTime.parse(String.valueOf(m.get("birthday")), DateTimeFormatter.ISO_LOCAL_DATE_TIME))
//                            .gender(String.valueOf(m.get("gender")))
//                            .description(String.valueOf(m.get("description")))
//                            .build();
//                    return member;
//                }
//        ).collect(Collectors.toList());
//        return memberList;

        return memberMapper.selectAllMembers();

    }
}