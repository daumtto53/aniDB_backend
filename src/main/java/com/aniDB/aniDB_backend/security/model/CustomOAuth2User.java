package com.aniDB.aniDB_backend.security.model;

import com.aniDB.aniDB_backend.security.dto.OAuth2UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CustomOAuth2User implements OAuth2User {

    private final Map<String, Object> attributes = new ConcurrentHashMap<>();

    public CustomOAuth2User(OAuth2UserDTO oAuth2UserDTO) {
        attributes.put("username", oAuth2UserDTO.getUsername());
        attributes.put("roles", oAuth2UserDTO.getRoles());
//        attributes.put("name", oAuth2UserDTO.getUsername());
//        attributes.put("email", oAuth2UserDTO.getEmail());
    }

    @Override
    public String getName() {
        return (String) attributes.get("username");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    /*
        List of String인 authorities를 GrantedAuthority 클래스를 만들어 반환한다.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = (List<String>) attributes.get("roles");
        Collection<GrantedAuthority> grantedAuthorities =
                roles.stream().map(role -> new GrantedAuthority() {
                    @Override
                    public String getAuthority() { return role; }
                }).collect(Collectors.toList());
        authorities.addAll(grantedAuthorities);
        return authorities;
    }
}
