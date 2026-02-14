package com.example.VeterinaryClinic.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VeterinaryClinic.DTO.AnimalDTO;
import com.example.VeterinaryClinic.Mapper.AnimalMapper;
import com.example.VeterinaryClinic.Service.AnimalService;

@Service

public class AnimalServiceImpl implements AnimalService {
	
	private final AnimalMapper animalMapper;
	
	public AnimalServiceImpl(AnimalMapper animalMapper) {
        this.animalMapper = animalMapper;
    }
	
	@Override
    public List<AnimalDTO> getDogs() {
        return animalMapper.getDogs();
    }
	
	@Override
    public List<AnimalDTO> getCats() {
        return animalMapper.getCats();
    }
}
