package com.example.demo.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    private static final String splitter = ";";

    // http://localhost:8888/swagger-ui/index.html
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("com.example.demo.jpa.controller;com.example.demo.redis.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Use Swagger to Display RESTFul")
                .description("Use Swagger to Display RESTFul")
                .version("1.0")
                .build();
    }

    public static Predicate<RequestHandler> basePackage(String basePackage) {
        return (input) -> (Boolean) declaringClass(input).map(handlerPackage(basePackage)).orElse(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return (input) -> {
            for (String strPackage : basePackage.split(splitter)) {
                boolean isMatch = ClassUtils.getPackageName(input).startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<Class<?>> declaringClass(RequestHandler input) {
        return Optional.ofNullable(input.declaringClass());
    }


//    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
//        return (input) -> {
//            return ClassUtils.getPackageName(input).startsWith(basePackage);
//        };
//    }
//
//    public static Predicate<RequestHandler> basePackage(String basePackage) {
//        return (input) -> {
//            return (Boolean)declaringClass(input).map(handlerPackage(basePackage)).orElse(true);
//        };
//    }
//
//    private static Optional<Class<?>> declaringClass(RequestHandler input) {
//        return Optional.ofNullable(input.declaringClass());
//    }
//
}
