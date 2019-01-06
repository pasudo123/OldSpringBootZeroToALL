package edu.doubler.todo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 유저 할 일 Dto <br>
 * @since 2019 01 05
 * @author PASUDO
 *
 */
@Getter
@Setter
public class UserTodoDto {

	private String name;
	private int age;
	private String title;
	private String content;
	
	public UserTodoDto(String name, int age, String title, String content) {
		this.name = name;
		this.age = age;
		this.title = title;
		this.content = content;
	}
}
