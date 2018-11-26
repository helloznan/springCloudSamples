package com.zn.micro.demo.helloworlddocker2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldDocker2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldDocker2Application.class, args);
	}
	
	@RequestMapping("hello")
	public String hello() {
		return "hello-world-docker2";
	}
}
