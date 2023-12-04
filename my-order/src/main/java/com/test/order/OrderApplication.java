package com.test.order;

import com.test.order.config.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Import(FeignConfig.class)
public class OrderApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(OrderApplication.class, args);
	}
}
