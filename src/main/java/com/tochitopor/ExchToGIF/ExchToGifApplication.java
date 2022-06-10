package com.tochitopor.ExchToGIF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchToGifApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchToGifApplication.class, args);
	}

}
