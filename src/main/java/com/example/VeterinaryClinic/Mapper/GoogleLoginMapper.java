package com.example.VeterinaryClinic.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.VeterinaryClinic.DTO.MemberDTO;

@Mapper
public interface GoogleLoginMapper {
	
	 MemberDTO getGoogleMember(String mail);

    // 구글 사용자 신규 저장
    int insertGoogleMember(MemberDTO user);

}
