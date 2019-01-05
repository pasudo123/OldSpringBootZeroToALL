package edu.doubler.todo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import edu.doubler.todo.service.TodoService;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class WebMockTodoController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TodoService todoService;
	
	@Test
	public void addTodoTest() throws Exception{

		this.mockMvc.perform(get("/add")).andExpect(status().isNotFound());
		this.mockMvc.perform(get("/todo/add")).andExpect(status().isOk());
		
		/**
		String testName = "T_NAME";
		int testAge = 10000;
		String testTitle = "T_TODO_TITLE";
		String testContent = "T_CONTENT";
		**/
		
		// when(todoService.addTodo(testName, testAge, testTitle, testContent))
	}
	
	@Test 
	public void modifyTodoTest() throws Exception{
		this.mockMvc.perform(get("/modify")).andExpect(status().isNotFound());
		this.mockMvc.perform(get("/todo/modify")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteTodoTest() throws Exception{
		this.mockMvc.perform(get("/delete")).andExpect(status().isNotFound());
		this.mockMvc.perform(get("/todo/delete")).andExpect(status().isOk());
	}
	
	@Test
	public void selectTodoTest() throws Exception{
		this.mockMvc.perform(get("/select")).andExpect(status().isNotFound());
		this.mockMvc.perform(get("/todo/select")).andExpect(status().isOk());
	}
}
