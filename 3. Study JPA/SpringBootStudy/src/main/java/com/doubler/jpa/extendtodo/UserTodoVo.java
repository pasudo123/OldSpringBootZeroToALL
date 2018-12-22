package com.doubler.jpa.extendtodo;

/**
 * [유저 및 할 일] 객체
 * @since 2018 12 22
 * @author PASUDO
 *
 */
public class UserTodoVo {
	
	private String title;
	private String content;
	private String name;
	private int age;
	
	public UserTodoVo(String title, String content, String name, int age) {
		super();
		this.title = title;
		this.content = content;
		this.name = name;
		this.age = age;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
