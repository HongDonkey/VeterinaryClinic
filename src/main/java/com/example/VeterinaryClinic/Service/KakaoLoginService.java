package com.example.VeterinaryClinic.Service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.VeterinaryClinic.DTO.MemberDTO;
import com.example.VeterinaryClinic.Mapper.KakaoLoginMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KakaoLoginService {

    private final KakaoLoginMapper kakaomemberMapper;
    private final String CLIENT_ID = "0ec842b0a2984fa23f7e2ac2315598af";
    private final String REDIRECT_URI = "http://localhost:8080/login/kakao/callback";

    // 1) code로 access token 받기
    public String getAccessToken(String code) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", CLIENT_ID);
        params.add("redirect_uri", REDIRECT_URI);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                request,
                Map.class
        );

        return (String) response.getBody().get("access_token");
    }

    // 2) access token으로 사용자 정보 가져오기
    public Map getKakaoUserInfo(String accessToken) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                request,
                Map.class
        );

        return response.getBody();
    }
    // 3) DB 저장 / 로그인 처리
    public MemberDTO saveOrUpdateKakaoUser(Map kakaoUserInfo) {
        Map kakaoAccount = (Map) kakaoUserInfo.get("kakao_account");
        Map profile = (Map) kakaoAccount.get("profile");
        Long kakaoId = ((Number) kakaoUserInfo.get("id")).longValue();

        String id = "kakao_" + kakaoId;
        String name = (String) profile.get("nickname");
        String mail = (String) kakaoAccount.get("email");

        MemberDTO member = kakaomemberMapper.getKakaoMember(id);
        if (member == null) {
        	MemberDTO newMember = new MemberDTO();
            newMember.setId(id);
            newMember.setName(name);
            newMember.setMail(mail);
            newMember.setInsUser(id);
            newMember.setModUser(id);

            kakaomemberMapper.insertKakaoMember(newMember);
            return newMember;
        }
        return member;
    }
}
