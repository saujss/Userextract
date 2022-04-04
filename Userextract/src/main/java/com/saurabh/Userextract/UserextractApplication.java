package com.saurabh.Userextract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.saurabh")
public class UserextractApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserextractApplication.class, args);
	}

}
