package com.example.VeterinaryClinic.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DeptDTO {
	private String name; // 분류 
	private String acro; // 실제 코드 값  

	private String insUser; // 최초 등록자
	private LocalDateTime insTime;
	private String modUser; // 최종 수정자
	private LocalDateTime modTime;
}
