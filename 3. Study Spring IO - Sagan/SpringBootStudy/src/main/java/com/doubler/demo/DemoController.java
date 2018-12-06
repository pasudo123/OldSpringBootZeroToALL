package com.doubler.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/demo")
public class DemoController {

	DemoService demoService;
	
	private static final Logger logger = Logger.getLogger(DemoController.class);
	
	@Autowired
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
		logger.info("ㅡㅡ DemoController 호출");
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public String demo() {
		return "demo";
	}
	
}
