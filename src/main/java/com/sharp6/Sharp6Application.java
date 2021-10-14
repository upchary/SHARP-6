package com.sharp6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.")
public class Sharp6Application {

	public static void main(String[] args) {
		SpringApplication.run(Sharp6Application.class, args);
		System.out.println("main method working");
	}

}
