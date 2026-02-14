package com.example.VeterinaryClinic.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.VeterinaryClinic.DTO.AnimalDTO;
@Mapper
public interface AnimalMapper {
    // 품종 조회
    List<AnimalDTO> getDogs();
    List<AnimalDTO> getCats();


}
