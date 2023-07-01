package com.emresahna.openapiexample;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@SecurityScheme(name = "BearerJWT", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer", description = "JWT Authentication")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(
						new Info()
							.title("Social Media API")
							.version("1.0.0")
							.description("Social Media API Description")
				)
				.addServersItem(
						new Server()
							.url("http://localhost:8080")
							.description("Development server")
				)
				.addServersItem(
						new Server()
							.url("https://api.example.com")
							.description("Production server")
				)
				.addTagsItem(
						new Tag()
							.name("PostController")
							.description("PostController API")
				)
				.addTagsItem(
						new Tag()
							.name("UserController")
							.description("UserController API")
				);
	}
}
