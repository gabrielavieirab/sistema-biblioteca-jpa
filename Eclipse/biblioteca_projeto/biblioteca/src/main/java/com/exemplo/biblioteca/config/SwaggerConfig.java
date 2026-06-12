package com.exemplo.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Biblioteca")
                        .version("1.0")
                        .description("Documentação da API para gerenciamento de livros, autores e editoras.")
                        .contact(new Contact()
                                .name("Desenvolvedor")
                                .email("contato@exemplo.com")));
    }
}
