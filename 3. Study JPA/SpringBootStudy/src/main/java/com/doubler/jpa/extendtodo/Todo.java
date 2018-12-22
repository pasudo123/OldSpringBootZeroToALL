package com.doubler.jpa.extendtodo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.doubler.jpa.extendtodo.User;

@Entity
@Table(name = "EXTEND_TODO")
public class Todo {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoId;
	
	private String title;
	private String content;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	// 기본 생성자는 JPA 만을 위해서 존재 (protected)
	protected Todo() {}
	
	// 디비에 저장되는 기본 생성자
	public Todo(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}

	/**
	 * GETTER() 
	 * @return
	 */
	
	public Long getTodoId() {
		return todoId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public User getUser() {
		return user;
	}
}