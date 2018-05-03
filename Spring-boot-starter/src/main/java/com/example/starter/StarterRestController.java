package com.example.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Rest")
public class StarterRestController {

	@Autowired
	private RestClient restClient;

	// @RequestMapping(path="/")
	@GetMapping(path = { "/", "/default" })
	public String sayDefault(@RequestParam(value = "name", defaultValue = "World") String param) {
		return "@default hello : " + param;
	}

	// @RequestMapping(path="/hello")
	@GetMapping(path = "/hello")
	public String sayHello(@RequestParam(value = "name", defaultValue = "World") String param) {
		return "hello : " + param;
	}

	// @RequestMapping(path="/hi")
	@GetMapping(path = "/hi")
	public String sayHi(@RequestParam(value = "name", defaultValue = "World") String param) {
		return "hi : " + param;
	}

	@GetMapping(path = "/search")
	public String search(@RequestParam(value = "cn", defaultValue = "IND") String countryCode,
			@RequestParam(value = "st", defaultValue = "WB") String stateCode) {
		return restClient.search(countryCode, stateCode);
	}

}
