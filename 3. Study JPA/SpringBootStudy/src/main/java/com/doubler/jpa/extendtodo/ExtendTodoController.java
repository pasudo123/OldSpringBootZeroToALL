package com.doubler.jpa.extendtodo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/extend/todo")
public class ExtendTodoController {
	
	public static final Logger logger = LogManager.getLogger(ExtendTodoController.class);
	
	private TodoRepository todoRepository;
	private UserRepository userRepository;
	
	@Autowired
	public ExtendTodoController(TodoRepository todoRepository, UserRepository userRepository) {
		
		logger.info("[doubler Log] ㅡㅡ> ExtendTodoController 생성자 호출");
		
		this.todoRepository = todoRepository;
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "/add")
	public String addTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		User user = new User(name, age);
		Todo todo = new Todo("Hello", "Hello World", user);
	
		userRepository.save(user);
		todoRepository.save(todo);
		
		return "Add Extend Todo";
	}
	
	
	@RequestMapping(value = "/modify")
	public String modifyTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		return null;
	}
	
	
	@RequestMapping(value = "delete")
	public String deleteTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		
		return null;
	}
	
	
	@RequestMapping(value = "select")
	public String selectTodo(
	@RequestParam(value = "name", defaultValue = "master", required = false) String name,
	@RequestParam(value = "age", defaultValue = "100", required = false) int age) {
		
		
		return null;
	}
}
