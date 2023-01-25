package com.lifi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableJpaAuditing 삭제
// WebMVCTest에 @Entity클래스가 필요하여 어노테이션 위치 변경(/config/JpaConfig)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
