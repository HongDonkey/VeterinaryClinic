package com.example.VeterinaryClinic.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
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
import com.example.VeterinaryClinic.Mapper.GoogleLoginMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoogleLoginService {

	private final GoogleLoginMapper googleLoginMapper;
	private final RestTemplate restTemplate = new RestTemplate();


    @Value("${google.client.id}")
    private String clientId;
    @Value("${google.client.secret}")
    private String clientSecret;

	private final String redirectUri = "http://localhost:8080/login/google/callback";

	// 고정 URL들
	private final String authUrl = "https://accounts.google.com/o/oauth2/v2/auth";
	private final String tokenUrl = "https://oauth2.googleapis.com/token";
	private final String userInfoUrl = "https://www.googleapis.com/oauth2/v2/userinfo";

	// 1) 구글 로그인 페이지 URL
	public String getAuthUrl() {
		return authUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code"
				+ "&scope=email%20profile";
	}

	// 2) code → access_token 교환
	private String getAccessToken(String code) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", redirectUri);
		params.add("grant_type", "authorization_code");

		HttpEntity<?> request = new HttpEntity<>(params, headers);

		ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

		return response.getBody().get("access_token").toString();
	}

	// 3) access_token → 사용자 정보 + DB 저장
	public MemberDTO handleLogin(String code) {

		String accessToken = getAccessToken(code);

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(accessToken);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<Map> response = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, Map.class);

		Map<String, Object> body = response.getBody();

		MemberDTO user = new MemberDTO();
		user.setId(body.get("id").toString());
		user.setMail(body.get("email").toString());
		user.setName(body.get("name").toString());
		System.out.println("user 확인" + user);
		// 이미 존재하는지 확인
		MemberDTO googleMember = googleLoginMapper.getGoogleMember(user.getId());
		if (googleMember == null) {
			googleLoginMapper.insertGoogleMember(user);
			googleMember = user;
		}

		return googleMember;
	}
}
