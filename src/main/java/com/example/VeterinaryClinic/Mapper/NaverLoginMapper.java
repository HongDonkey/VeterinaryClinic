package com.example.VeterinaryClinic.Mapper;

import com.example.VeterinaryClinic.DTO.MemberDTO;

public interface NaverLoginMapper {
	
	MemberDTO getNaverMember(String mail);
	
    void insertNaverMember(MemberDTO member);
}
