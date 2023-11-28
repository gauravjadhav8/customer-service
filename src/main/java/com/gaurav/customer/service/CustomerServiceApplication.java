package com.gaurav.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CustomerServiceApplication implements WebMvcConfigurer {
	public static void main(final String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}


}