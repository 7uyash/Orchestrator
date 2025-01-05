package com.orch.orch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrchApplication {

	public static void main(String[] args) {
		System.out.println("App Started");
		SpringApplication.run(OrchApplication.class, args);
		System.out.println("App Loaded");
	}

}
