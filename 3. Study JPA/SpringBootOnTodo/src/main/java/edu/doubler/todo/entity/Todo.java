package edu.doubler.todo.entity;

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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(force = true)
@ToString
@Entity
@Table(name = "TODO")
public class Todo {
	
	@Id
	@Column(name = "TODO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long todoId;
	
	@Column(name = "TITLE") 
	private String title;
	
	@Column(name = "CONTENT") 
	private String content;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	public Todo(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}
	
	public Todo(Long todoId, String title, String content, User user) {
		this.todoId = todoId;
		this.title = title;
		this.content = content;
		this.user = user;
	}
}
