package edu.doubler.sample;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import edu.doubler.todo.controller.TodoController;

// https://meetup.toast.com/posts/124
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {SampleController.class, SampleService.class})
@WebMvcTest(SampleController.class)
public class SampleControllerTest {
		
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SampleService sampleService;
	
	@Test 
	public void testFoo() throws Exception {
		when(sampleService.getSampleFoo()).thenReturn("Hello Mock SampleFoo");
		this.mockMvc.perform(get("/sample/foo")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello Mock SampleFoo")));
	}
	
	@Test
	public void testBar() throws Exception{
		when(sampleService.getSampleBar()).thenReturn("Hello Mock SampleBar");
		this.mockMvc.perform(get("/sample/bar")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello Mock SampleBar")));
	}
}
