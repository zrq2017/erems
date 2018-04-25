package com.zrq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zrq.dao")
public class EremsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EremsApplication.class, args);
	}
}
