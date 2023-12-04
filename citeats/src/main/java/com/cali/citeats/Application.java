package com.cali.citeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cali.citeats")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
        System.out.println("Hello, Earl!"); 

	}

}


