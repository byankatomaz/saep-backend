package com.saep.saep.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.saep.saep.backend")
public class SaepBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaepBackendApplication.class, args);
	}

}
