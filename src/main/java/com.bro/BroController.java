package com.bro;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BroController {

	@RequestMapping("/")
	public String index() {
		return "Bro!";
	}

}
