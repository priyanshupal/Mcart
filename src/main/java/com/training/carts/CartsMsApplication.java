package com.training.carts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CartsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartsMsApplication.class, args);
	}

}
