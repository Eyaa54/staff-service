package com.hospital.staffservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Personnalise le titre affiché en haut de Swagger.
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI staffOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Staff Service API - Hopital")
                .description("Gestion des medecins, des services et des plannings")
                .version("1.0"));
    }
}
