package com.assignment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "company-service",
				version = "1.0.0",
				description = "Microservice to manage Company entity.",
				termsOfService = "Tutorial purpose. Runs only on localhost:8081 port as of now."
		)
)
public class CompanyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CompanyServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
