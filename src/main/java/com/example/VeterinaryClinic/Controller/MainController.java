package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpSession session, Model model) {
		Object loginMember = session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
		return "/main/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) {
		Object loginMember = session.getAttribute("loginMember");
        model.addAttribute("loginMember", loginMember);
        if(model.getAttribute("loginMember") != null) {
        	return "redirect:/";
        }
		return "/login/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // 세션 초기화
	    return "redirect:/";  // 홈으로 리다이렉트
	}

}
