package com.storeapp.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("StoreApp API")    // Titel in Swagger
                        .version("v1")
                        .description("API für StoreApp mit Produkten und Accounts"))
                .components(new Components()
                        .addSecuritySchemes("basicScheme",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
<<<<<<< HEAD
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
=======
                                        .scheme("basic")))
>>>>>>> f7b2480b7a793429ea2ae60fb627f730e2fc91d2
                .addSecurityItem(new SecurityRequirement().addList("basicScheme"));
    }
}
