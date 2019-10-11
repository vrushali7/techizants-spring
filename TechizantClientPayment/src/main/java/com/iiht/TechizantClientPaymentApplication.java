package com.iiht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TechizantClientPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechizantClientPaymentApplication.class, args);
	}

}
