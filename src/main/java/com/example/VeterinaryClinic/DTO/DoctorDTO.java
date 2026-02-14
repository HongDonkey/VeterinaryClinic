package com.example.VeterinaryClinic.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DoctorDTO {
	private String id; 
	private String name; 
	private String dept; 


	private String insUser; // 최초 등록자
	private LocalDateTime insTime;
	private String modUser; // 최종 수정자
	private LocalDateTime modTime;
}

