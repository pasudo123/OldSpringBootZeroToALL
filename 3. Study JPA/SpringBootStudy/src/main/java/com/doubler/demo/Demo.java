package com.doubler.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Demo {

	@Id
	private Integer sequence;
	private String name;
	
	
	
}
	