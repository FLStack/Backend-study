package com.example.studybackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // React(Vite) 포트 허용 (CORS 해결)
public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "Spring Boot 연동 성공!";
    }
}