package com.spring.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.spring.restapi"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Sample API implementation using Spring boot",
                "Free to use",
                "1.0",
                "Free to use",
                new Contact("Mohammad Alqayem", "https://github.com/mohammadnabil666/SpringBoot-RestAPI-Sample", "mohammadnabil666@gmail.com"),
                "API License",
                "LICENCE",
                Collections.emptyList());

        return apiInfo;
    }
}
