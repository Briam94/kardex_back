package com.kardex.kardex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kardex")
@EntityScan("com.kardex.entities")
public class KardexApplication {

	public static void main(String[] args) {
		SpringApplication.run(KardexApplication.class, args);
	}

}
