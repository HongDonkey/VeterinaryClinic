package com.example.VeterinaryClinic.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.VeterinaryClinic.DTO.AnimalDTO;
import com.example.VeterinaryClinic.DTO.DeptDTO;
import com.example.VeterinaryClinic.DTO.DoctorDTO;
import com.example.VeterinaryClinic.DTO.ReservationDTO;
import com.example.VeterinaryClinic.Service.AnimalService;
import com.example.VeterinaryClinic.Service.DeptService;
import com.example.VeterinaryClinic.Service.DoctorService;
import com.example.VeterinaryClinic.Service.ReservationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {
	
	private final DeptService deptService;
	private final DoctorService doctorService;
	private final AnimalService animalService;
	private final ReservationService reservationService;
	
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
	
	@RequestMapping(value = "/reservation/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> save(@RequestBody ReservationDTO reservationDTO) {
		String resvNo = reservationService.generateResvNo();
		
		reservationDTO.setResvNo(resvNo);
		
		
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		LocalDate localDate = LocalDate.parse(reservationDTO.getDate(), inputFormatter);
		String date = localDate.format(outputFormatter);

		
		reservationDTO.setResvTime(date+ reservationDTO.getTime());

	    int result = reservationService.insertReservation(reservationDTO);

	    if (result > 0) {
	        return ResponseEntity.ok("SUCCESS");
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("FAIL");
	    }
	}

	
}
