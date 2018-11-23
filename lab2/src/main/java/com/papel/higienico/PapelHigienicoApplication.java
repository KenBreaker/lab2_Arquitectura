package com.papel.higienico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class PapelHigienicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PapelHigienicoApplication.class, args);
	}
}
