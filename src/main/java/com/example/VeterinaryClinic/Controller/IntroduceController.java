package com.example.VeterinaryClinic.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IntroduceController {

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String history() {

		return "/introduce/KU_VM_TH_sub5_3";
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String department() {

		return "/introduce/KU_VM_TH_sub5_3";
	}
	
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map() {

		return "/introduce/KU_VM_TH_sub5_3";
	}
	@RequestMapping(value = "/maptest", method = RequestMethod.GET)
	public String mapTest() {

		return "/introduce/k_map";
	}
	
}
