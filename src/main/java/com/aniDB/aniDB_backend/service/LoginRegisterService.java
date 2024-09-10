package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.member.BasicRegisterMemberDTO;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.MemberRole;
import com.aniDB.aniDB_backend.entity.Role;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.MemberRoleRepository;
import com.aniDB.aniDB_backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class LoginRegisterService {
    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(BasicRegisterMemberDTO basicRegisterMemberDTO) {
        Member hasMember = memberRepository.findByLoginId(basicRegisterMemberDTO.getLoginId());
        if (hasMember != null)
            return;
        Member member = Member.builder()
                .isFromSocial(basicRegisterMemberDTO.isFromSocial())
                .loginId(basicRegisterMemberDTO.getLoginId())
                .username(UUID.nameUUIDFromBytes(basicRegisterMemberDTO.getLoginId().getBytes()).toString())
                .password(bCryptPasswordEncoder.encode(basicRegisterMemberDTO.getMember_password()))
                .nickname(basicRegisterMemberDTO.getLoginId())
                .build();
        memberRepository.save(member);
        Role roleUser = roleRepository.findByName("ROLE_USER");
        MemberRole memberRole = MemberRole.builder()
                .memberId(member.getMemberId())
                .roleId(roleUser.getRoleId())
                .build();
        memberRoleRepository.saveMemberRole(memberRole);
    }

}
