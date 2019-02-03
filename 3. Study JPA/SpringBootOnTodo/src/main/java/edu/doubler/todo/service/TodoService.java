package edu.doubler.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.doubler.todo.dto.UserTodoDto;
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
	
	/**
	 * 할 일 등록 모듈 <br>
	 * @param name
	 * @param age
	 * @param todoTitle
	 * @param todoContent
	 */
	public void addTodo(String name, Integer age, String todoTitle, String todoContent) {
		
		name = (name == null)? "TEST NAME" : name;
		age = (age == null)? 100 : age;
		todoTitle = (todoTitle == null)? "TEST TITLE" : todoTitle;
		todoContent = (todoContent == null)? "TEST CONTENT" : todoContent;
		
		User user = new User(name, age);
		Todo todo = new Todo(todoTitle, todoContent, user);
		
		todoRepository.save(todo);
	}

	/**
	 * 할 밀 수정 모듈 <br>
	 * @param name
	 * @param title
	 * @param content
	 * @return boolean
	 */
	public boolean updateTodo(String name, String title, String content) {
		
		logger.info("조회 -- name :: " + name);
		logger.info("변경 -- title :: " + title);
		logger.info("변경 -- content :: " + content);
		
		List<Integer> todoIdList = todoRepository.findTodoIdByUserName(name);
		
		if(todoIdList.size() == 0) {
			return false;
		}
		
		// https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data
		for(Integer todoId : todoIdList) {
			Todo todo = todoRepository.getOne(todoId);
			
			todo.setTitle(title);
			todo.setContent(content);
			todoRepository.save(todo);
		}
		
		return true;
	}
	
	/**
	 * 할 일 삭제 모듈 <br>
	 * @param name
	 * @return
	 */
	public boolean deleteTodo(String name) {
		
		List<Integer> todoIdList = todoRepository.findTodoIdByUserName(name);
		
		if(todoIdList.size() == 0) {
			return false;
		}
		
		for(Integer todoId : todoIdList) {
			todoRepository.deleteById(todoId);
		}
		
		return true;
	}
	
	/**
	 * 할 일 목록 획득 모듈 <br>
	 * @return
	 */
	public List<Todo> getTodoList(){
		
		List<Todo> todoList = todoRepository.findAll();
		
		return todoList;
	}
	
	/**
	 * 유저에 대한 할 일 목록 획득 모듈 <br>
	 * @param todoList
	 * @return
	 */
	public List<UserTodoDto> getUserListOnTodo(List<Todo> todoList){
		
		List<UserTodoDto> userTodoList = new ArrayList<UserTodoDto>();
	
		for(Todo todo : todoList) {
			
			String title = todo.getTitle();
			String content = todo.getContent();
			User user = todo.getUser();
			
			userTodoList.add(new UserTodoDto(user.getName(), user.getAge(), title, content));
		}
		
		return userTodoList;
	}
	
}
