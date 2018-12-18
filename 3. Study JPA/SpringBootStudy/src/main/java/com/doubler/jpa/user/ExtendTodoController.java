package com.doubler.jpa.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/extend/todo")
public class ExtendTodoController {
	
	public static final Logger logger = LogManager.getLogger(ExtendTodoController.class);
	
	
	
}
