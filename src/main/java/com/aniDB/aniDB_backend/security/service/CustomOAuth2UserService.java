package com.aniDB.aniDB_backend.security.service;

import com.aniDB.aniDB_backend.security.dto.NaverResponseDTO;
import com.aniDB.aniDB_backend.security.dto.OAuth2Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        /*
            리소스 서버에서 oAuth2 표준을 통해 userInfo를 가져온다.
         */
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;
        oAuth2Response = getoAuth2Response(registrationId, oAuth2User);
        if (oAuth2Response == null) return null;

        String username = oAuth2Response.getProviderId();

        /*
            반환한 member의 정보로
                1. user가 이미 DB에 등록되어있다면, update만 시키고, authentication을 만든다.
                2. 없다면, 새로 rdb에 등록시키고, authentication을 만든다.
             0. 반환한다.
         */
//        Optional<Member> member = memberRepository.findByUsername(username);
//
//        if (member.isEmpty()) {
//        }
//        else {
//        }
        return null;
    }

    private static OAuth2Response getoAuth2Response(String registrationId, OAuth2User oAuth2User) {
        OAuth2Response oAuth2Response;
        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponseDTO(oAuth2User.getAttributes());
        } else {
            return null;
        }
        return oAuth2Response;
    }
}
