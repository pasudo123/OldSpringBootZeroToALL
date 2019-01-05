package edu.doubler.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller(value = "/sample")
public class SampleController {

	private SampleService sampleService;
	
	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	@GetMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(value = "/foo")
	@ResponseBody
	public String foo() {
		return sampleService.getSampleFoo();
	}
	
	@GetMapping(value = "/bar")
	@ResponseBody
	public String bar() {
		return sampleService.getSampleBar();
	}
}
