package edu.doubler.todo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.doubler.todo.entity.Todo;
import edu.doubler.todo.entity.User;
import edu.doubler.todo.repository.TodoRepository;

@Service
public class TodoService {
		
	private static final Logger logger = LogManager.getLogger(TodoService.class);
	
	private TodoRepository todoRepository = null;
	
	@Autowired
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	public void addTodo(String name, Integer age, String todoTitle, String todoContent) {
		
		name = (name == null)? "TEST NAME" : name;
		age = (age == null)? 100 : age;
		todoTitle = (todoTitle == null)? "TEST TITLE" : todoTitle;
		todoContent = (todoContent == null)? "TEST CONTENT" : todoContent;
		
		User user = new User(name, age);
		Todo todo = new Todo(todoTitle, todoContent, user);
		
		todoRepository.save(todo);
	}

	public List<Todo> getTodoList(){
		
		List<Todo> todoList = todoRepository.findAll();
		
		return null;
	}
	
	public List<User> getUserListOnTodo(List<Todo> todoList){
		
		for(Todo todo : todoList) {
			
		}
		
		return null;
	}
	
}
