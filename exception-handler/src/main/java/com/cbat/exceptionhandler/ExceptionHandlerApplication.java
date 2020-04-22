package com.cbat.exceptionhandler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExceptionHandlerApplication {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ExceptionHandlerApplication.class);
		ConfigurableApplicationContext run = SpringApplication.run(ExceptionHandlerApplication.class, args);
		logger.error("test--------------------------error");
		logger.info("test--------------------------info");
		logger.debug("test--------------------------debug");
	}

}
