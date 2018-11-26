package com.zn.micro.demo.weathercollectionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class city_Application {

	public static void main(String[] args) {
		SpringApplication.run(city_Application.class, args);
	}
}
