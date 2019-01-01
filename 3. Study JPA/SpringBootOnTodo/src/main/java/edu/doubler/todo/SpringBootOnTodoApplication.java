package edu.doubler.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"edu.doubler.*"})
@SpringBootApplication
public class SpringBootOnTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOnTodoApplication.class, args);
	}

}

