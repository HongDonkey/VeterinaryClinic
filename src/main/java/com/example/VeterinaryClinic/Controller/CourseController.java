package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController {

	@RequestMapping(value = "/internalTeam", method = RequestMethod.GET)
	public String internalTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	@RequestMapping(value = "/surgicalTeam", method = RequestMethod.GET)
	public String surgicalTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	@RequestMapping(value = "/ophthTeam", method = RequestMethod.GET)
	public String ophthTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	@RequestMapping(value = "/radiologyTeam", method = RequestMethod.GET)
	public String radiologyTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	@RequestMapping(value = "/pathologyTeam", method = RequestMethod.GET)
	public String pathologyTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	@RequestMapping(value = "/criticalTeam", method = RequestMethod.GET)
	public String criticalTeam() {

		return "/medicalTeam/KU_VM_TH_sub4_1";
	}
	
	
	
}
