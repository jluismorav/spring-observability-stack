package com.endava.example.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;

@RestController
@Timed
public class MainController {
	@Autowired
	public MyComponent component;

	@GetMapping("/index")	
	public String index() {
		component.countedCall();
		return "Hello World";
	}

}
