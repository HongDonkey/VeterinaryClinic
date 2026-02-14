package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VeterinaryClinic.DTO.MemberDTO;
import com.example.VeterinaryClinic.Service.GoogleLoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@Transactional
public class GoogleLoginController {

	private final GoogleLoginService googleLoginService;

	// 1. 구글 로그인 URL로 보내기
	@GetMapping("/login/google")
	public String loginRedirect() {
		return "redirect:" + googleLoginService.getAuthUrl();
	}

	// 2. Callback — code 처리
	@GetMapping("login/google/callback")
	public String googleCallback(@RequestParam("code") String code, HttpSession session) {
		MemberDTO member = googleLoginService.handleLogin(code);

		// 로그인 성공 → 세션 저장
		session.setAttribute("loginMember", member);

		return "redirect:/"; // 네이버, 카카오와 동일하게 처리
	}
}
