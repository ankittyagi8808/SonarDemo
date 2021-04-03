package com.qrux.discussion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.qrux.discussion.repositories")
public class DemoApplication   {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
