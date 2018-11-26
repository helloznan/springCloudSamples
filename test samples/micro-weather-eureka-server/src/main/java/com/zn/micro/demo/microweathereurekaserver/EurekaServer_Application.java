package com.zn.micro.demo.microweathereurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer_Application.class, args);
	}
}
