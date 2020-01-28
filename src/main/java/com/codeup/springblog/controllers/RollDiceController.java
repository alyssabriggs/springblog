package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

	@GetMapping("/roll-dice")
	public String selection(){
		return "roll-dice";
	}

	@PostMapping("/roll-dice")
	public String chooseNum(@RequestParam int num, Model model){
		model.addAttribute("num", num);
		return "roll-dice/n";

	}
}
