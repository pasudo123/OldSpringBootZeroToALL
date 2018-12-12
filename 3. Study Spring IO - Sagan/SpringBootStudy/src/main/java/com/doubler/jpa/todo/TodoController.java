package com.doubler.jpa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( value = "/todo" )
public class TodoController {

	private static final String ADD_COMPLETE = "ADD COMPLEIETE";
	
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoController(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping( value = "/add", method = {RequestMethod.GET})
	@ResponseBody
	public String addTodo(
	@RequestParam String title,
	@RequestParam String content,
	@RequestParam String author) {
		
		Todo todo = new Todo(title, content, author);
		todoRepository.save(todo);
		
		return ADD_COMPLETE;
	}
	
}
