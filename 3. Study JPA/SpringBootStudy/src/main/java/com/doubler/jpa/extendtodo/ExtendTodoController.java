package com.doubler.jpa.extendtodo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/extendtodo")
public class ExtendTodoController {
	
	public static final Logger logger = LogManager.getLogger(ExtendTodoController.class);
	
	private ExtendTodoService extendTodoService;
	
	@Autowired
	public ExtendTodoController(ExtendTodoService extendTodoService) {
		
		logger.info("[doubler Log] ㅡㅡ> ExtendTodoController 생성자 호출");
		this.extendTodoService = extendTodoService;
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String addTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
	
		return extendTodoService.addUserTodo(name, age);

	}
	
	
	@RequestMapping(value = "/modify")
	@ResponseBody
	public String modifyTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		return null;
	}
	
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		
		return null;
	}
	
	
	@RequestMapping(value = "/select")
	@ResponseBody
	public List<UserTodoVo> selectTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		return extendTodoService.getUserTodoList();
		
	}
}
