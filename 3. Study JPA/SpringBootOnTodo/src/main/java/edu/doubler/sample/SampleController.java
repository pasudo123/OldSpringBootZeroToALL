package edu.doubler.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/sample")
public class SampleController {

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello";
	}
}
