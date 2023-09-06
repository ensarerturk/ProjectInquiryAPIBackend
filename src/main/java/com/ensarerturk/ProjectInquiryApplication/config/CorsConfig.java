package com.ensarerturk.ProjectInquiryApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Enables Spring Web MVC.
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Method to configure CORS policies.

        // Allows requests to "/api/**" path.
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200") // Only requests from this origin are allowed (e.g., where the Angular application is hosted).
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods.
                .allowedHeaders("*"); // Allows all headers.
    }
}