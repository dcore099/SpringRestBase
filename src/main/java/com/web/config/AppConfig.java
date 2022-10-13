package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.web.model.Employee;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.web.*")
public class AppConfig {

	@Bean
	public Employee getEmployee() {
		Employee ob = new Employee();
		ob.setName("Juan");
		ob.setAge(Integer.valueOf(33));
		ob.setJob("Manager");
		
		return ob;
	}
}
