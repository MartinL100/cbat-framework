package com.cbat.exceptionhandler;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExceptionHandlerApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(ExceptionHandlerApplication.class, args);

	}

}
