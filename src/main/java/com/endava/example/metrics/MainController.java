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

	@GetMapping("/")
	@Timed(extraTags = { "mytagname", "mytagvalue" })
	public String index() {
		component.countedCall();
		System.out.println("Hello World");
		return "Hello World";
	}

}
