package com.dipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan("com.dipl.model")
//@ComponentScan("{com.dipl.controller}")
public class CrudSpringBootBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootBookApplication.class, args);
	}

}
