package com.blogapplication.blogapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Spring Boot Blog App Rest API",
		description = "Spring Boot Blog APIS Documentations",
		version = "v1.0",
		contact = @Contact(
			name = "MD MOHOSIN MIAH",
			email = "mohosin.miah@bd.adventurekk.com"
		),
		license = @License(
			name = "ApacheFree"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "This is Blog App developed by Fun Guy",
		url = "https://github.com/MohosinMiah"
	)
)
public class BlogapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogapplicationApplication.class, args);
	}

	

}
