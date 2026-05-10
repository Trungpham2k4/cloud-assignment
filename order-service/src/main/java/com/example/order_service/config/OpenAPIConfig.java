package com.example.order_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI orderServiceAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service")
                        .version("1.0")
                        .description("This is the Order Service API"))
                .externalDocs(new ExternalDocumentation()
                        .description("You can find out more about the order service")
                        .url("https://dummy-service.github.io"));
    }
}
