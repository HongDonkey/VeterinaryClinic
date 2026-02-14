package com.example.VeterinaryClinic.Service;

import java.util.List;

import com.example.VeterinaryClinic.DTO.AnimalDTO;

public interface AnimalService {
	List<AnimalDTO> getDogs();
	List<AnimalDTO> getCats();

}
