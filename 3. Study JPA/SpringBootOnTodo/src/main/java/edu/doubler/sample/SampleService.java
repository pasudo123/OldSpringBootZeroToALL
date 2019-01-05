package edu.doubler.sample;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	public String getSampleFoo() {
		return "Hello SampleFoo";
	}
	
	public String getSampleBar() {
		return "Hello SampleBar";
	}
}
