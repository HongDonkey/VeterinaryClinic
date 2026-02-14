package com.example.VeterinaryClinic.Controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VeterinaryClinic.Service.NaverLoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NaverLoginController {

	private final NaverLoginService naverLoginService;
    @Value("${naver.client.id}")
    private String clientId;
	// 1) naver 로그인 페이지 리다이렉트
	@GetMapping("/login/naver")
	public String naverLogin() {
		String redirectUri = URLEncoder.encode("http://localhost:8080/login/naver/callback", StandardCharsets.UTF_8);
		String state = UUID.randomUUID().toString(); // CSRF 방지

		String url = "https://nid.naver.com/oauth2.0/authorize" + "?client_id=" + clientId + "&response_type=code"
				+ "&redirect_uri=" + redirectUri + "&state=" + state;

		return "redirect:" + url;

	}

	@GetMapping("/login/naver/callback")
	public String naverCallback(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession session) {

		// 네이버 로그인 처리 서비스 호출
		Map<String, Object> result = naverLoginService.processNaverLogin(code, state);

		// 로그인 성공 → 세션 저장
		session.setAttribute("loginMember", result.get("member"));

		return "redirect:/";
	}
}
