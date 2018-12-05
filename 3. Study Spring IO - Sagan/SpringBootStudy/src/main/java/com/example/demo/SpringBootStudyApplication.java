package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"edu.double.*", "com.exaple.*"})
@SpringBootApplication
public class SpringBootStudyApplication {

	private static final Logger logger = Logger.getLogger(SpringBootStudyApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootStudyApplication.class, args);
		
//		for(String name : applicationContext.getBeanDefinitionNames()) {
//			logger.info(name);
//		}
		
	}
}
