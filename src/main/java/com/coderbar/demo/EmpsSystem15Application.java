package com.coderbar.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = { "com.coderbar.demo.mapper" }, sqlSessionFactoryRef = "sqlSessionFactory")
@SpringBootApplication
public class EmpsSystem15Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpsSystem15Application.class, args);
	}

}
