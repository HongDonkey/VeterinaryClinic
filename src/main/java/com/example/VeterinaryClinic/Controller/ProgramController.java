package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProgramController {

	@RequestMapping(value = "/healthInfo", method = RequestMethod.GET)
	public String helathInfo() {

		return "/program/KU_VM_TH_sub6_1";
	}
	
	@RequestMapping(value = "/bloodDonation", method = RequestMethod.GET)
	public String bloodDonation() {

		return "/program/KU_VM_TH_sub6_1";
	}
	
	@RequestMapping(value = "/fund", method = RequestMethod.GET)
	public String fund() {

		return "/program/KU_VM_TH_sub6_1";
	}
	
}
