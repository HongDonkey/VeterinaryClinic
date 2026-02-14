package com.example.VeterinaryClinic.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.VeterinaryClinic.DTO.DeptDTO;
import com.example.VeterinaryClinic.Mapper.DeptMapper;
import com.example.VeterinaryClinic.Service.DeptService;

@Service

public class DeptServiceImpl implements DeptService {
	
	private final DeptMapper deptMapper;
	
	public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }
	
	@Override
    public List<DeptDTO> getAllDept() {
        return deptMapper.getAllDept();
    }



}
