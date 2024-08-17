package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.MemberRole;
import com.aniDB.aniDB_backend.entity.Role;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberRoleMapperTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MemberRoleMapper memberRoleMapper;

    static Role testRole;
    static Long testMemberId;
    static MemberRole testMemberRole;

    @BeforeEach
    public void setup() {
        Member member = Member.builder()
                .username("test")
                .password("test")
                .loginId("test")
                .build();
        memberRepository.saveNecessary(member);
        testMemberId = member.getMemberId();
        testRole = roleRepository.findByName("ROLE_USER");
        testMemberRole = MemberRole.builder().memberId(testMemberId).roleId(testRole.getRoleId()).build();
        memberRoleMapper.insertMemberRole(testMemberRole);
    }

    @Test
    @Order(1)
    void insertMemberRole() {
        MemberRole testMemberRole = MemberRole.builder()
                .roleId(testRole.getRoleId())
                .memberId(testMemberId).build();
        memberRoleMapper.insertMemberRole(testMemberRole);

        Assertions.assertThat(testMemberRole.getMemberId()).isEqualTo(testMemberId);
        Assertions.assertThat(testMemberRole.getRoleId()).isEqualTo(testRole.getRoleId());
    }

    @Test
    void selectMemberRoleById() {
        MemberRole memberRole = memberRoleMapper.selectMemberRoleById(testMemberRole.getMemberId(), testMemberRole.getRoleId());
        Assertions.assertThat(testMemberRole.getMemberId()).isEqualTo(memberRole.getMemberId());
        Assertions.assertThat(testMemberRole.getRoleId()).isEqualTo(memberRole.getRoleId());
    }

    @Test
    void selectMemberRoleByMemberId() {
        //given

        //when
        List<MemberRole> memberRoles = memberRoleMapper.selectMemberRoleByMemberId(testMemberRole.getMemberId());
        System.out.println(memberRoles);
        //then
        Assertions.assertThat(memberRoles.size()).isEqualTo(1);
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void deleteMemberRole() {
        int i = memberRoleMapper.deleteMemberRole(testMemberRole.getMemberId(), testMemberRole.getRoleId());
        Assertions.assertThat(i).isEqualTo(1);
    }

    @Test
    void selectAllMemberRoles() {
        List<MemberRole> memberRoles = memberRoleMapper.selectAllMemberRoles();
        Assertions.assertThat(memberRoles.size()).isEqualTo(1);
    }
}