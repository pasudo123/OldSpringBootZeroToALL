package edu.doubler.todo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.doubler.todo.dto.UserTodoDto;
import edu.doubler.todo.entity.Todo;
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
		
		logger.info("----> 유저의 할 일 목록을 등록하는 컨트롤러 진입");

		todoService.addTodo(name, age, todoTitle, todoContent);
		
		return "Add Todo";
	}
	
	@RequestMapping(value = "/update/{name}")
	@ResponseBody
	public String updateUserTodo(
	@PathVariable String name,
	@RequestParam (value = "title", required = false) String title,
	@RequestParam (value = "content", required = false) String content) {
		
		logger.info("----> 유저의 할 일을 수정하는 컨트롤러 진입");
		
		// TODO Pathvariable 에서 띄어쓰기 문제??
		
		boolean isUpdate = todoService.updateTodo(name, title, content);
		
		if(!isUpdate) {
			return "Not been Updated";
		}
		
		return "Updated Todo";
	}
	
	@RequestMapping(value = "/delete/{name}")
	@ResponseBody
	public String deleteUserTodo(
	@PathVariable String name) {
	
		logger.info("----> 유저의 할 일을 삭제하는 컨트롤러 진입");
		// TODO 삭제 모듈 구현.
		
		boolean isDelete = todoService.deleteTodo(name);
		
		if(!isDelete) {
			return "Not been Deleted";
		}
		
		return "Deleted Todo";
	}
	
	@RequestMapping(value = "/select")
	@ResponseBody
	public List<UserTodoDto> selectUserTodo() {
		
		logger.info("----> 유저 할 일 목록을 조회하는 컨트롤러 진입");
		
		List<Todo> todoList = todoService.getTodoList();
		List<UserTodoDto> userTodoList = todoService.getUserListOnTodo(todoList);
		
		return userTodoList;
	}
}
