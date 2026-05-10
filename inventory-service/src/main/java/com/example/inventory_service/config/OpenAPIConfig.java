package com.example.inventory_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI inventoryServiceAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Service")
                        .version("1.0")
                        .description("This is the Inventory Service API"))
                .externalDocs(new ExternalDocumentation()
                        .description("You can find out more about the inventory service")
                        .url("https://dummy-service.github.io"));
    }
}
