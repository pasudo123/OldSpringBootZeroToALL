package edu.doubler.todo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
<<<<<<< HEAD
=======
import static org.mockito.Mockito.when;
>>>>>>> develop

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
	
<<<<<<< HEAD
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
	
=======
	/**
	 * given / when / then 으로 이어지는 형태 <br>
	 * 추후에 스프링 내장 DB 로 구현하는 것이 효율적일 수도 있음 <br>
	 */
	@Test
	public void simpleTodoSerivceTest() {
		
		/**
		 * (1) given <br>
		 */
		List<Todo> expectedTodoList = Arrays.asList(
			new Todo(null, "첫번째 타이틀", "첫번째 내용", new User(null, "토마토", 10)),
			new Todo(null, "두번째 타이틀", "두번째 내용", new User(null, "고구마", 20)),
			new Todo(null, "세번째 타이틀", "세번째 내용", new User(null, "오렌지", 30))
		);
		
		when(todoRepository.findAll()).thenReturn(expectedTodoList);

		/**
		 * (2) when <br>
		 * (3) then <br>
		 */
		List<Todo> todoList = todoService.getTodoList();
		assertThat(todoList).isEqualTo(expectedTodoList);
	}
>>>>>>> develop
}
