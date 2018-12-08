package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.doubler.customer.Customer;
import com.doubler.customer.CustomerRepository;

@EntityScan({"com.doubler.*", "com.example.*"})
@EnableJpaRepositories({"com.doubler.*", "com.example.*"})
@ComponentScan({"com.doubler.*", "com.example.*"})
@SpringBootApplication
public class SpringBootStudyApplication {

	private static final Logger logger = Logger.getLogger(SpringBootStudyApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootStudyApplication.class, args);
	}
	
	/**
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) ->{
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "'O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Pamler"));
			repository.save(new Customer("Michelle", "Dessler"));
			
			// fetch all customers
			logger.info("Customers found with findAll()");
			logger.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			for(Customer customer : repository.findAll()) {
				logger.info(customer.toString());
			}
			
			logger.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			
			// fetch customers by last name
			logger.info("Customer found with findByLastName('Bauer'):");
			logger.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			
			repository.findByLastName("Bauer").forEach(bauer -> {
				logger.info(bauer.toString());
			});
			
			logger.info("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		};
	}
	**/
}
