package com.school.message;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.school.message.web.mapper"})
public class MessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

}
