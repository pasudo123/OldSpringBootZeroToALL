package com.doubler.jpa.extendtodo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtendTodoService {

	private TodoRepository todoRepository;
	private UserRepository userRepository;
	
	@Autowired
	public ExtendTodoService(TodoRepository todoRepository, UserRepository userRepository) {
		this.todoRepository = todoRepository;
		this.userRepository = userRepository;
	}
	
	public String addUserTodo(String name, int age) {
		
		User user = new User(name, age);
		Todo todo = new Todo("Hello", "Hello World", user);
	
		userRepository.save(user);
		todoRepository.save(todo);
		
		return "Add Extend Todo";
	}
	
	public List<UserTodoVo> getUserTodoList() {
		return getExtractUserNameAndAge(todoRepository.findAll());
	}
	
	private List<UserTodoVo> getExtractUserNameAndAge(List<Todo> todoList){

		List<UserTodoVo> userTodoList = new ArrayList<UserTodoVo>();
		
		for(Todo todo : todoList) {
			String title = todo.getTitle();
			String content = todo.getContent();
			User user = todo.getUser();
			String name = user.getName();
			int age = user.getAge();
			
			userTodoList.add(new UserTodoVo(title, content, name, age));
		}
		
		return userTodoList;
	}
}
