package com.example.VeterinaryClinic.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VeterinaryClinic.DTO.MemberDTO;
import com.example.VeterinaryClinic.Service.KakaoLoginService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class KakaoLoginController {

    private final KakaoLoginService kakaoLoginService;
    @Value("${kakao.client.secret}")
    private String clientId;
    // 1) 카카오 로그인 페이지 리다이렉트
    @GetMapping("/login/kakao")
    public String kakaoLogin() {
    
        String redirectUri = "http://localhost:8080/login/kakao/callback";
        String url = "https://kauth.kakao.com/oauth/authorize"
                + "?client_id=" + clientId
                + "&redirect_uri=" + redirectUri
                + "&response_type=code";

        return "redirect:" + url;
    }

    // 2) 카카오 callback 처리
    @GetMapping("/login/kakao/callback")
    public String kakaoCallback(@RequestParam("code") String code, HttpSession session, Model model) {
    	// 1) code -> access token
        String accessToken = kakaoLoginService.getAccessToken(code);

        // 2) access token -> 사용자 정보
        Map kakaoUserInfo = kakaoLoginService.getKakaoUserInfo(accessToken);

        // 3) DB 저장 / 로그인 처리
        MemberDTO member = kakaoLoginService.saveOrUpdateKakaoUser(kakaoUserInfo);

        // 4) 세션에 로그인 정보 저장
        session.setAttribute("loginMember", member);

        model.addAttribute("member", member);
        return "redirect:/"; // main.html로 이동
    }
}
