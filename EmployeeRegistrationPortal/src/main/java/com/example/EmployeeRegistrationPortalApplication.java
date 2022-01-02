package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import repository.EmployeeRepository;


@Configuration
@SpringBootApplication(scanBasePackages={"service", "model", "repository", "controller"})
@EnableJpaRepositories("repository")
@EntityScan("model")   
public class EmployeeRegistrationPortalApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationPortalApplication.class, args);
	}

}
