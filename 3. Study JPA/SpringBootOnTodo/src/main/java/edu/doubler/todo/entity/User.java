package edu.doubler.todo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * reference :: https://hyojoy.blogspot.com/2018/04/lombok_15.html
 * @since 2018 12 23
 * @author PASUDO
 *
 */
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "NAME") 
	private String name;
	
	@Column(name = "AGE") 
	private int age;

	// @Column(name=  "USER_ID") private String userId;
	// @Column(name = "USER_PW") private String userPw;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
