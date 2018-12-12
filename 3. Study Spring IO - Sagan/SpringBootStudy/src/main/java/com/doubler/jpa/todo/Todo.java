package com.doubler.jpa.todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TODO")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String content;
	private String author;
	
	// 기본 생성자는 JPA 만을 위해서 존재 (protected)
	protected Todo() {}
	
	// 디비에 저장되는 기본 생성자
	public Todo(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	// getter() & setter()
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Todo [title=" + title + ", content=" + content + ", author=" + author + "]";
	}
}