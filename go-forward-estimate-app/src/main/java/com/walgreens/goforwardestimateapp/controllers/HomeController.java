package com.walgreens.goforwardestimateapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@ResponseBody
	@GetMapping("/home")
	public String home() {
		return "Hi";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	/*@PostMapping("/createNewEstimate")
	public ModelAndView createNewEstimate() {
		return new ModelAndView("createNewEstimate", "welcomeMessage", "Welcome to Estimation App");
	}*/

	@PostMapping("/updateExistingEstimate")
	public ModelAndView updateExistingEstimate() {
		return new ModelAndView("updateExistingEstimate", "welcomeMessage", "Welcome to Estimation App");
	}

	@PostMapping("/reporting")
	public ModelAndView reporting() {
		return new ModelAndView("reporting", "welcomeMessage", "Welcome to Reporting");
	}

	@PostMapping("/userProfileMaintenance")
	public ModelAndView userProfileMaintenence() {
		return new ModelAndView("userProfileMaintenance", "welcomeMessage", "Welcome to User Profile Maintenance");
	}

	@PostMapping("/estimationRuleMaintenance")
	public ModelAndView estimationRuleMaintenance() {
		return new ModelAndView("estimationRuleMaintenance", "welcomeMessage",
				"Welcome to Estimation Rule Maintenance");
	}

}
