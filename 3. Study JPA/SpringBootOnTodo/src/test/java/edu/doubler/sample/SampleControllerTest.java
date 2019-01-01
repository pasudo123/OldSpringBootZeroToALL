package edu.doubler.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// https://meetup.toast.com/posts/124
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SampleController.class})
public class SampleControllerTest {
		
	
	@Autowired 
	SampleController sampleController;
	
	
	@Test 
	public void testFoo() {
		System.out.println("Hello");
	}
}
