package com.example.VeterinaryClinic.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.VeterinaryClinic.DTO.AnimalDTO;
import com.example.VeterinaryClinic.DTO.DeptDTO;
import com.example.VeterinaryClinic.DTO.DoctorDTO;
import com.example.VeterinaryClinic.Service.AnimalService;
import com.example.VeterinaryClinic.Service.DeptService;
import com.example.VeterinaryClinic.Service.DoctorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {
	
	private final DeptService deptService;
	private final DoctorService doctorService;
	private final AnimalService animalService;
	
	@RequestMapping(value = "/notice_schd", method = RequestMethod.GET)
	public String noticeSchd(Model model) {
		
		List<DeptDTO> deptList = deptService.getAllDept();
		model.addAttribute("deptList", deptList);
		
		return "/reservation/KU_VM_TH_sub1_1";
	}
	
	@RequestMapping(value = "/reservation", method = RequestMethod.GET)
	public String reservation(Model model) {
		
		List<DeptDTO> deptList = deptService.getAllDept();
		model.addAttribute("deptList", deptList);

		return "/reservation/KU_VM_TH_sub1_2";
	}
	
	@RequestMapping(value = "/select_reservation", method = RequestMethod.GET)
	public String selectReservation() {

		return "/reservation/KU_VM_TH_sub1_3";
	}
	
	@RequestMapping(value = "/reservation/doctors", method = RequestMethod.GET)
	@ResponseBody
	public List<DoctorDTO> reservationDoctors(@RequestParam("dept") String dept) {

	    return doctorService.getDoctor(dept);
	}
	
	@RequestMapping(value = "/reservation/dogs", method = RequestMethod.GET)
	@ResponseBody
	public List<AnimalDTO> getDogs() {

	    return animalService.getDogs();
	}
	
	@RequestMapping(value = "/reservation/cats", method = RequestMethod.GET)
	@ResponseBody
	public List<AnimalDTO> getCats() {

	    return animalService.getCats();
	}

	
}
