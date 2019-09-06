package com.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

	@Value("${user.userName}")
	private String userName;
	
	@RequestMapping("/login")
	public String login() {
		return "hello"+userName;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
