package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
//RollBack
@Transactional
//Test 순서 정하기
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")
class MemberMapperTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberMapper memberMapper;

    private Long setupMemberid;

    @BeforeEach
    public void MemberSetup() {
        Member member = Member.builder()
                .username("123")
                .password("123")
                .loginId("loginId")
                .build();
        memberRepository.saveNecessary(
                member
        );
        setupMemberid = member.getMemberId();
    }

    @Test
    @Order(1)
    void insertMember() {

    }

    @Test
    @Order(1)
    void insertMemberNecessary() {
        //given
        //when
        Member member =
                Member.builder()
                        .username("username1")
                        .password("password1")
                        .loginId("loginId1")
                        .build();
        memberRepository.saveNecessary(member);
        //then
        Member getMember = memberRepository.findById(member.getMemberId());
        Assertions.assertThat(getMember.getMemberId()).isEqualTo(member.getMemberId());
        System.out.println(memberRepository.findAll());
    }

    @Test
    void selectMemberById() {
        Member byId = memberRepository.findById(setupMemberid);
        System.out.println(byId);
        Assertions.assertThat(byId.getMemberId()).isEqualTo(setupMemberid);
    }

    @Test
    void updateMember() {

    }

    @Test
    @Order(Integer.MAX_VALUE-1)
    void deleteMember() {
        int effectRows = memberRepository.delete(setupMemberid.intValue());

        Assertions.assertThat(effectRows).isEqualTo(1);
        Assertions.assertThat(memberRepository.findById(setupMemberid)).isEqualTo(null);
    }

    @Test
    @Order(2)
    void selectAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList);
        System.out.println(setupMemberid);
        Assertions.assertThat(memberList.size()).isEqualTo(1);
    }

}