package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MedicalTeamController {

	@RequestMapping(value = "/internal", method = RequestMethod.GET)
	public String internal() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	@RequestMapping(value = "/surgical", method = RequestMethod.GET)
	public String surgical() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	@RequestMapping(value = "/ophth", method = RequestMethod.GET)
	public String ophth() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	@RequestMapping(value = "/radiology", method = RequestMethod.GET)
	public String radiology() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	@RequestMapping(value = "/pathology", method = RequestMethod.GET)
	public String pathology() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	@RequestMapping(value = "/critical", method = RequestMethod.GET)
	public String critical() {

		return "/course/KU_VM_TH_sub3_1";
	}
	
	
	
}
