package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new StandardPasswordEncoder();
	}
}
