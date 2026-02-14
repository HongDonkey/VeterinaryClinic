package com.example.VeterinaryClinic.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.VeterinaryClinic.DTO.MemberDTO;

@Mapper
public interface KakaoLoginMapper {

	MemberDTO getKakaoMember(String id);
	
	void insertKakaoMember(MemberDTO member);
	
	
}
