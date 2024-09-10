package com.aniDB.aniDB_backend.security.model;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.repository.MemberRoleRepository;
import com.aniDB.aniDB_backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Log4j2
public class CustomUserDetails implements UserDetails {
    private final Member member;
    private final MemberRoleRepository memberRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                String roleName = "ROLE_USER";
//                String roleName = roleRepository.findById(memberRoleRepository.findMemberRolesByMemberId(member.getMemberId()).get(0).getRoleId()).getRoleName();
                log.info("roleName={}", roleName);
                return roleName;
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }
}
