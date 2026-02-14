package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DiagnosisController {

	@RequestMapping(value = "/reception", method = RequestMethod.GET)
	public String reception() {

		return "/diagnosis/KU_VM_TH_sub2_1";
	}
	
	@RequestMapping(value = "/admission", method = RequestMethod.GET)
	public String admission() {

		return "/diagnosis/KU_VM_TH_sub2_2";
	}
	
	@RequestMapping(value = "/emergency", method = RequestMethod.GET)
	public String emergency() {

		return "/diagnosis/KU_VM_TH_sub2_3";
	}
	
}
