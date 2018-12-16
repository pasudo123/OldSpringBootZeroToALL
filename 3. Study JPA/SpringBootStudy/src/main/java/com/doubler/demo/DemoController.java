package com.doubler.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

	private DemoService demoService = null;
	
	private static final Logger logger = LogManager.getLogger(DemoController.class);
	
	@Autowired
	public DemoController(DemoService demoService) {
		logger.info("[doubler Log] ㅡㅡ> DemoController 생성자 호출");
		this.demoService = demoService;
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public String demo() {
		logger.info("[doubler Log] ㅡㅡ> DemoController 에서 RequestMapping 으로 \"/demo\" URL 접근");
		return "demo";
	}
	
//	@RequestMapping(value = "/{demoName}", method = {RequestMethod.GET, RequestMethod.POST})
	
}
