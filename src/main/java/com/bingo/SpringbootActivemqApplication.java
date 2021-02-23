package com.bingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringbootActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActivemqApplication.class, args);
	}

}
