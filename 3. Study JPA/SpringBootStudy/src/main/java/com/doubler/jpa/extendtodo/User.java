package com.doubler.jpa.extendtodo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String name;
	private int age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Todo> todos;
	
	protected User() {}
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// getter() & setter()
	
	public Long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
