package com.spring.thymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = { "com.spring.thymeleaf.repository" })
public class ComSpringThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComSpringThymeleafApplication.class, args);
	}

}
