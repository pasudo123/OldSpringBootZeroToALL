package com.doubler.jpa.todo;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( value = "/todo" )
public class TodoController {

	private static final Logger logger = LogManager.getLogger(TodoController.class);
	
	private TodoRepository todoRepository;
	
	@Autowired
	public TodoController(TodoRepository todoRepository) {
		
		logger.info("[doubler Log] ㅡㅡ> TodoController 생성자 호출");
		
		this.todoRepository = todoRepository;
	}

	/**
	 * JPA 할 일 등록 <br>
	 * @param title
	 * @param content
	 * @param author
	 * @return
	 */
	@RequestMapping( value = "/add", method = {RequestMethod.GET})
	@ResponseBody
	public String addTodo(
	@RequestParam String title,
	@RequestParam String content,
	@RequestParam String author) {
		
		Todo todo = new Todo(title, content, author);
		todoRepository.save(todo);
		logger.info(":: add TODO ::");
		
		return "Add Todo";
	}
	
	/**
	 * JPA 할 일 조회 <br>
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	@ResponseBody
	public Object selectTodo(
	@RequestParam(value = "id", required = false) Long id) {
		if(id == null) {
			return selectAll();
		}
		else {
			return selectOne(id);
		}
	}
	
	/**
	 * JPA 할 일 [전체] 조회 <br>
	 * @return
	 */
	public List<Todo> selectAll(){
		List<Todo> todoList = todoRepository.findAll();
		logger.info(":: SELECT ALL ::");
		return todoList;
	}

	/**
	 * JPA 할 일 [1 개] 조회 <br>
	 * @param id
	 * @return
	 */
	public HashMap<String, Object> selectOne(long id){
		Optional<Todo> todoOptional = todoRepository.findById(id);
		Todo todo = todoOptional.get();
		logger.info(":: SELECT ONE ::");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", todo.getId());
		map.put("title", todo.getTitle());
		map.put("content", todo.getContent());
		map.put("author", todo.getAuthor());
		return map;
	}
	
	/**
	 * JPA 할 일 [한 개] 삭제 <br>
	 * @return
	 */
	@RequestMapping( value = "/delete", method = RequestMethod.GET )
	@ResponseBody
	public String deleteOneTodo(
	@RequestParam Long id) {

		/**
		 * 엔티티 하나를 삭제한다. <br>
		 * 내부에서 EntityManager.remove() 호출 <br>
		 */
		todoRepository.deleteById(id);
		logger.info(":: delete TODO :: TODO Id >>" + id);
		
		
		return "Delete Todo";
	}
	
	/**
	 * JPA 할 일 수정 <br>
	 * @param id
	 * @param title
	 * @param content
	 * @param author
	 * @return
	 */
	@RequestMapping ( value = "/update", method = RequestMethod.GET )
	@ResponseBody
	public String updateTodo(
	@RequestParam(required = false) Long id,
	@RequestParam(value = "title", required = false) String title,
	@RequestParam(value = "content", required = false) String content,
	@RequestParam(value = "author", required = false) String author) {
		
		if(id == null) {
			return "null id";
		}
		
		boolean isExist = todoRepository.existsById(id);
		
		if(isExist) {
			Todo todo = todoRepository.getOne(id);
			
			title = (title == null) ? "" : title;
			content = (content == null) ? "" : content;
			author = (author == null) ? "" : author;
		
			logger.info("title --> " + title);
			logger.info("content --> " + content);
			logger.info("author --> " + author);
			
			todo.setTitle(title);
			todo.setContent(content);
			todo.setAuthor(author);
			todoRepository.save(todo);
		}
		
		return (isExist) ? "Update Todo" : "Not Exist Data";
	}
}
