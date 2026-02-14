package com.example.VeterinaryClinic.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.VeterinaryClinic.DTO.DoctorDTO;
@Mapper
public interface DoctorMapper {
    // 의사 조회
    List<DoctorDTO> getDoctor(@Param("dept") String dept);


}
