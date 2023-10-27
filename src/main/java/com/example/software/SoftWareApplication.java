package com.example.software;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.software.mapper")
public class SoftWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftWareApplication.class, args);
    }

}
