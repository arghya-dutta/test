package com.example.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class StarterController {

	// @RequestMapping(path="/")
	@GetMapping(path = { "/", "/default" })
	public String sayDefault(@RequestParam(value = "name", defaultValue = "World") String param, Model model) {
		model.addAttribute("user", "@Default " + param);
		return "hello";
	}

	// @RequestMapping(path="/hello")
	@GetMapping(path = "/hello")
	public String sayHello(@RequestParam(value = "name", defaultValue = "World") String param, Model model) {
		model.addAttribute("user", param);
		return "hello";
	}

	// @RequestMapping(path="/hi")
	@GetMapping(path = "/hi")
	public String sayHi(@RequestParam(value = "name", defaultValue = "World") String param, Model model) {
		model.addAttribute("user", param);
		return "hello";
	}

}
