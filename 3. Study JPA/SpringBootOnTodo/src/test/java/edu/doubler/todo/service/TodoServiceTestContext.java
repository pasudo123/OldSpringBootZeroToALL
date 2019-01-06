package edu.doubler.todo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.doubler.todo.entity.Todo;
import edu.doubler.todo.entity.User;
import edu.doubler.todo.repository.TodoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TodoService.class})
public class TodoServiceTestContext {

	@Autowired
	TodoService todoService;
	
	@MockBean
	private TodoRepository todoRepository;
	
	@Test
	public void simpleTodoSerivceTest() {
		List<Todo> expectedTodoList = Arrays.asList(
			new Todo("첫번째 타이틀", "첫번째 내용", new User("토마토", 10)),
			new Todo("두번째 타이틀", "두번째 내용", new User("고구마", 20)),
			new Todo("세번째 타이틀", "세번째 내용", new User("오렌지", 30))
		);
		
		// given(todoRepository.findAll()).willReturn(expectedTodoList);
		
		List<Todo> todoList = todoService.getTodoList();
		assertThat(todoList).isEqualTo(expectedTodoList);
	}
	
}
