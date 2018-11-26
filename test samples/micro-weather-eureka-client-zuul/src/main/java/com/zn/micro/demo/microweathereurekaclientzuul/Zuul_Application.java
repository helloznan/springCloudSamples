package com.zn.micro.demo.microweathereurekaclientzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Zuul_Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul_Application.class, args);
	}
}
