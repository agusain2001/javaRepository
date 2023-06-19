package com.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.validation.entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

	
	@GetMapping("/myform")
	public String openForm(Model model) {
		model.addAttribute("LoginData", new LoginData());
		return "form";
	}
	
	//handler for process form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("LoginData") LoginData loginData,BindingResult result ) {
		if(result.hasErrors()) {
			return "form";
		}
		return "success";
	}
	

	
	

}
