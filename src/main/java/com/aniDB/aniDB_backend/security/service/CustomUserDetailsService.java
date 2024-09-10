package com.aniDB.aniDB_backend.security.service;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.MemberRole;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.MemberRoleRepository;
import com.aniDB.aniDB_backend.repository.RoleRepository;
import com.aniDB.aniDB_backend.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member foundMember = memberRepository.findByLoginId(username);
        if (foundMember != null) {
            return new CustomUserDetails(foundMember, memberRoleRepository, roleRepository);
        }

        return null;
    }
}
