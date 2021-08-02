package com.ssafy.B303.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController{
	
	@RequestMapping(value = "/mvIntroduce", method = RequestMethod.GET)
	public String introduce() {
		return "introduce";
	}
	
	@RequestMapping(value = "/mvNeighborInfo", method = RequestMethod.GET)
	public String neighborinfo() {
		return "neighborInfo";
	}
	@RequestMapping(value = "/mvEnvironmentInfo", method = RequestMethod.GET)
	public String environmentinfo() {
		return "environmentinfo";
	}
	
}