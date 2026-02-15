package com.example.VeterinaryClinic.Service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.VeterinaryClinic.DTO.MemberDTO;
import com.example.VeterinaryClinic.Mapper.NaverLoginMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class NaverLoginService {

	private final NaverLoginMapper naverMemberMapper;
	 @Value("${naver.client.id}")
	    private String clientId;
	 @Value("${naver.client.secret}")
	    private String clientSecret;
	public Map<String, Object> processNaverLogin(String code, String state) {

        String redirectUri = "http://localhost:8080/login/naver/callback";

        // ⬇ Access Token 요청
        String tokenUrl = "https://nid.naver.com/oauth2.0/token"
                + "?grant_type=authorization_code"
                + "&client_id=" + clientId
                + "&client_secret=" + clientSecret
                + "&code=" + code
                + "&state=" + state;

        RestTemplate rt = new RestTemplate();
        String response = rt.getForObject(tokenUrl, String.class);

        JSONObject json = new JSONObject(response);
        String accessToken = json.getString("access_token");

        // ⬇ 사용자 정보 요청
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> userInfoResponse = rt.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.GET,
                entity,
                String.class
        );

        JSONObject userJson = new JSONObject(userInfoResponse.getBody())
                .getJSONObject("response");

        String mail = userJson.optString("email");
        String name = userJson.optString("name");
        String id = userJson.optString("id");
        String phone = userJson.optString("mobile");

        // Member 객체 생성
        MemberDTO member = new MemberDTO();
        member.setMail(mail);
        member.setName(name);
        member.setId(id);
        member.setPhone(phone);

        // DB에 저장 또는 업데이트
        MemberDTO naverMember = naverMemberMapper.getNaverMember(mail);

        if (naverMember == null) {
        	naverMemberMapper.insertNaverMember(member);
            naverMember = member;
        }

        Map<String, Object> result = new HashMap<>();
        result.put("member", naverMember);

        return result;
    }
}
