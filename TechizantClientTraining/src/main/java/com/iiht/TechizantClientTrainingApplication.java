package com.iiht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class TechizantClientTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechizantClientTrainingApplication.class, args);
	}

}
