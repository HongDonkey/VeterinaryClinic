package com.example.VeterinaryClinic.Mapper;

import com.example.VeterinaryClinic.DTO.ReservationDTO;

public interface ReservationMapper {
	
	//MemberDTO getNaverMember(String mail);
	
    int insertReservation(ReservationDTO reservation);
    String generateResvNo();
}
