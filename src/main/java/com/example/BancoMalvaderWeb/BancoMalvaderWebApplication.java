package com.example.BancoMalvaderWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping
public class BancoMalvaderWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoMalvaderWebApplication.class, args);
	}

}
