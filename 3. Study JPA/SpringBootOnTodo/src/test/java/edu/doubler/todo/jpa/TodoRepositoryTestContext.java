package edu.doubler.todo.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import edu.doubler.todo.repository.TodoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTestContext {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void whenFindNameThenReturnTodo() {
		
		// given
		// when
		// then
			
	}
	
}
