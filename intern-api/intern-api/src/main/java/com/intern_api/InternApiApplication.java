package com.intern_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternApiApplication {

	private static final Logger log = LoggerFactory.getLogger(InternApiApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(InternApiApplication.class, args);
		log.info("Intern Sample Started");
	}

}
