package org.itstep;

import org.itstep.model.User;
import org.itstep.model.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationRunner {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
		
	}
}
