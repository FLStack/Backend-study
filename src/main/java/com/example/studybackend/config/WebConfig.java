package com.example.studybackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해
                .allowedOriginPatterns(
                        "http://localhost:5173",
                        "https://*.vercel.app" // Vercel 배포 주소 모두 허용
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // DELETE 및 OPTIONS 허용 필수!
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}