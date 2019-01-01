package edu.doubler.todo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.doubler.todo.service.TodoService;

/**
 * 사용자 할 일 Controller <br>
 * @since 2018 12 23
 * @author PASUDO
 *
 */
@Controller
@RequestMapping(value = "/todo")
public class TodoController {

	private static final Logger logger = LogManager.getLogger(TodoController.class);
	
	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String addUserTodo(
	@RequestParam (value = "name", required = false) String name,
	@RequestParam (value = "age", required = false) Integer age,
	@RequestParam (value = "title", required = false) String todoTitle,
	@RequestParam (value = "content", required = false) String todoContent) {
		
		logger.info("----> Add User Todo Controller");
		logger.info("name :: " + name);
		logger.info("age :: " + age);
		logger.info("title :: " + todoTitle);
		logger.info("content :: " + todoContent);

		todoService.addTodo(name, age, todoTitle, todoContent);
		
		return "Add Todo";
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String deleteUserTodo(
	@RequestParam (value = "name", required = false) String name) {
		
		
		
		return "Delete Todo";
	}
	
}
