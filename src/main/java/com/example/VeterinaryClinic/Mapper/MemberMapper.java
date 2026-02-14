package com.example.VeterinaryClinic.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.VeterinaryClinic.DTO.MemberDTO;

@Mapper
public interface MemberMapper {

	MemberDTO getMember(String id);
	
	void insertMember(MemberDTO member);
	
	
}
