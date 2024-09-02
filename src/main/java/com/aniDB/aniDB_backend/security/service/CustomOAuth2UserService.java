package com.aniDB.aniDB_backend.security.service;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.MemberRole;
import com.aniDB.aniDB_backend.entity.Role;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.MemberRoleRepository;
import com.aniDB.aniDB_backend.repository.RoleRepository;
import com.aniDB.aniDB_backend.security.dto.NaverResponseDTO;
import com.aniDB.aniDB_backend.security.dto.OAuth2Response;
import com.aniDB.aniDB_backend.security.dto.OAuth2UserDTO;
import com.aniDB.aniDB_backend.security.model.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final MemberRoleRepository memberRoleRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        /*
            리소스 서버에서 oAuth2 표준을 통해 userInfo를 가져온다.
         */
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;
        oAuth2Response = getoAuth2Response(registrationId, oAuth2User);
        if (oAuth2Response == null)
            return null;

        String username = oAuth2Response.getProviderId();
        /*
            반환한 member의 정보로
                1. user가 이미 DB에 등록되어있다면, update만 시키고, authentication을 만든다.
                2. 없다면, 새로 rdb에 등록시키고, authentication을 만든다.
             0. 반환한다.
         */
        Member member = memberRepository.findByUsername(username);
        if (member == null) {
            registerOAuth2ResponseToMember(username, oAuth2Response);
            OAuth2UserDTO userDTO = createUserDTO(username, oAuth2Response);
            return new CustomOAuth2User(userDTO);
        }
        else {
            NaverResponseDTO naverResponseDTO = (NaverResponseDTO) oAuth2Response;
            member.setEmail(naverResponseDTO.getEmail());
            member.setName(naverResponseDTO.getName());
//            member.setGender(naverResponseDTO.getGender());
//            member.setBirthday(convertBirthdayBirthyearToLocalDateTime(naverResponseDTO.getBirthday(), naverResponseDTO.getBirthYear()));
            member.setNickname(naverResponseDTO.getNickname());
            memberRepository.update(member);
            List<String> rolesList = roleRepository.findByMemberId(member.getMemberId());
            OAuth2UserDTO userDTO = createuserDTO(username, member, rolesList);
            return new CustomOAuth2User(userDTO);
        }

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

    private static OAuth2UserDTO createuserDTO(String username, Member member, List<String> rolesList) {
        OAuth2UserDTO userDTO = OAuth2UserDTO.builder()
                .username(username)
                .name(member.getName())
                .email(member.getEmail())
                .roles(rolesList)
                .build();
        return userDTO;
    }

    private static OAuth2UserDTO createUserDTO(String username, OAuth2Response oAuth2Response) {
        OAuth2UserDTO userDTO = OAuth2UserDTO.builder()
                .username(username)
                .name(oAuth2Response.getName())
                .email(oAuth2Response.getEmail())
                .roles(Arrays.asList("ROLE_USER"))
                .build();
        return userDTO;
    }

    private void registerOAuth2ResponseToMember(String username, OAuth2Response oAuth2Response) {
        NaverResponseDTO naverResponseDTO = (NaverResponseDTO) oAuth2Response;
        Member member = Member.builder()
                .username(username)
                .email(oAuth2Response.getEmail())
                .loginId(oAuth2Response.getProviderId())
                .password(username)
                .isFromSocial(true)
                .isDisabled(false)
                .name(oAuth2Response.getName())
                .nickname(naverResponseDTO.getNickname())
//                .birthday(convertBirthdayBirthyearToLocalDateTime(naverResponseDTO.getBirthday(), naverResponseDTO.getBirthYear()))
//                .gender(naverResponseDTO.getGender())
                .build();
        memberRepository.save(member);
        //Role 추가
        registerMemberRole(member);
    }

    private void registerMemberRole(Member member) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        MemberRole memberRole = MemberRole.builder()
                .roleId(roleUser.getRoleId())
                .memberId(member.getMemberId())
                .build();
        memberRoleRepository.saveMemberRole(memberRole);
    }

    private LocalDateTime convertBirthdayBirthyearToLocalDateTime(String birthday, String birthYear) {        // Define date formats
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        // Parse the birth year and birthday strings
        int year = Integer.parseInt(birthYear);

        // Combine birthday and birthYear to a complete date string
        String fullDateString = birthday + "-" + year;

        // Parse the complete date string to LocalDate
        LocalDate birthDate = LocalDate.parse(fullDateString, dateTimeFormatter);

        // Convert to LocalDateTime with default time (e.g., midnight)
        LocalDateTime birthDateTime = birthDate.atStartOfDay();
        return birthDateTime;
    }
}
