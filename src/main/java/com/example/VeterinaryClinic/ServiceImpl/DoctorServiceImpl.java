package com.example.VeterinaryClinic.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VeterinaryClinic.DTO.DoctorDTO;
import com.example.VeterinaryClinic.Mapper.DoctorMapper;
import com.example.VeterinaryClinic.Service.DoctorService;

@Service

public class DoctorServiceImpl implements DoctorService {
	
	private final DoctorMapper DoctorMapper;
	
	public DoctorServiceImpl(DoctorMapper DoctorMapper) {
        this.DoctorMapper = DoctorMapper;
    }
	
	@Override
    public List<DoctorDTO> getDoctor(String dept) {
        return DoctorMapper.getDoctor(dept);
    }
}
