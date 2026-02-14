package com.example.VeterinaryClinic;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.VeterinaryClinic.DTO.MemberDTO;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {
	// 모든 컨트롤러에서 세션에 값을 담아보낼 순 없으므로 ControllerAdvice 어노테이션 사용
	// 스프링프레임워크에서 예외 처리 코드를 중복해서 작성하지 않고, 전체 컨트롤러에 대한 전역적인 예외처리를 정의 할 수 있다.
	// 컨트롤러 메소드에서 예외가 발생하면 ControllerAdvice가 이를 가로채고 정의된 예외 처리 로직을 적용한다.
    @ModelAttribute("loginMember")
    public MemberDTO addLoginMember(HttpSession session) {
        return (MemberDTO) session.getAttribute("loginMember");
    }
}