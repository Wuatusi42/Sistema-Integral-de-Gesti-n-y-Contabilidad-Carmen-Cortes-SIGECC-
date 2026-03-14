package com.utrng.sigecc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SigeccApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigeccApplication.class, args);
	}

}
