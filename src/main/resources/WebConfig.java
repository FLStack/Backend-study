package com.example.studybackend.config; // 👈 본인 프로젝트의 패키지 경로에 맞게 수정하세요

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:5173",                 // 로컬 React/Vite 주소
                        "https://frontend-nu-coral-33.vercel.app/"  // 👈 본인의 Vercel 사이트 주소로 변경
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}