package com.example.VeterinaryClinic.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.VeterinaryClinic.DTO.DeptDTO;
@Mapper
public interface DeptMapper {
    // 모든 부서 조회
    List<DeptDTO> getAllDept();


}
