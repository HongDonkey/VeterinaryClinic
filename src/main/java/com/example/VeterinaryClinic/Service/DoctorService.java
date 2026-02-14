package com.example.VeterinaryClinic.Service;

import java.util.List;

import com.example.VeterinaryClinic.DTO.DoctorDTO;

public interface DoctorService {
	List<DoctorDTO> getDoctor(String dept);

}
