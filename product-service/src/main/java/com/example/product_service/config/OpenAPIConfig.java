package com.example.product_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Product Service")
                        .version("1.0")
                        .description("Product Service API"))
                .externalDocs(new ExternalDocumentation()
                        .description("Product Service API")
                        .url("https://product-service.github.io"));
    }
}
