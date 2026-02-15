package com.example.VeterinaryClinic.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReservationDTO {
	private String resvNo; 
	private String name; 
	private String phone; 
	private String mail;
	private String date;
	private String time;
	private String animalType; 
	private String animalKind;
	private String dept; 
	private String doctorId; 
	private String title; 
	private String resvTime;
	private String symp; 
	
	private String insUser; // 최초 등록자
	private LocalDateTime insTime;
	private String modUser; // 최종 수정자
	private LocalDateTime modTime;
}

