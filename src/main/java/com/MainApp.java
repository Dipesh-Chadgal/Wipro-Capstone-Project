package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Spring Boot application.
 * <p>
 * This class is responsible for bootstrapping and launching the application.
 * It uses {@link SpringBootApplication}, which is a convenience annotation 
 * that combines {@code @Configuration}, {@code @EnableAutoConfiguration}, 
 * and {@code @ComponentScan}.
 * </p>
 */

@SpringBootApplication
public class MainApp {
	
	 /**
     * The main method that starts the Spring Boot application.
     *
     * @param args Command-line arguments passed during application startup.
     */
	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}
