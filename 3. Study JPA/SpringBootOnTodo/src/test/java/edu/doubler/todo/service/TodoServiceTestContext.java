package edu.doubler.todo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.doubler.todo.entity.Todo;
import edu.doubler.todo.entity.User;
import edu.doubler.todo.repository.TodoRepository;
import edu.doubler.todo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TodoService.class})
public class TodoServiceTestContext {

	@Autowired
	TodoService todoService;
	
	@MockBean
	private TodoRepository todoRepository;
	
	@MockBean 
	private UserRepository userRepository;
	
	@After
	public void cleanUp() {
		userRepository.deleteAll();
	}
	
	/**
	 * given / when / then 으로 이어지는 형태 <br>
	 * 추후에 스프링 내장 DB 로 구현하는 것이 효율적일 수도 있음 <br>
	 */
	@Test
	public void simpleTodoSerivceTest() {
		
		/**
		 * (1) given <br>
		 * :: 테스트 기반 환경을 구축하는 단계 <br>
		 */
		List<Todo> expectedTodoList = Arrays.asList(
			new Todo(null, "첫번째 타이틀", "첫번째 내용", new User(null, "토마토", 10)),
			new Todo(null, "두번째 타이틀", "두번째 내용", new User(null, "고구마", 20)),
			new Todo(null, "세번째 타이틀", "세번째 내용", new User(null, "오렌지", 30))
		);
		
		when(todoRepository.findAll()).thenReturn(expectedTodoList);

		/**
		 * (2) when <br>
		 * :: 테스트하고자 하는 행위 선언
		 * 
		 * (3) then <br>
		 * :: 테스트 결과 검증
		 */
		List<Todo> todoList = todoService.getTodoList();
		assertThat(todoList).isEqualTo(expectedTodoList);
	}
	
	@Test 
	public void 유저_불러오기() {
		
		/**
		 * H2 BASE 를 통한 테스트 환경이 되어 있기 떄문에 아래의 예제는 통과된다. <p>
		 * 내가 구현한 부분에서는 구현이 안됨.. <p>
		 */
		
		// (1) given
		userRepository.save(User.builder()
				.userId(500)
				.name("더블러")
				.age(100)
				.build());
		
		// (2) when
		List<User> userList = userRepository.findAll();
		
		// (3) then
		User user = userList.get(0);
		assertThat(user.getName(), is("더블러"));
		assertThat(user.getAge(), is(100));
	}
}
