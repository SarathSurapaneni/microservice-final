package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import com.cts.config.ItemServiceRibbonConfiguration;

@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "item-service", configuration = ItemServiceRibbonConfiguration.class)
public class SalesOrdersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrdersServiceApplication.class, args);
	}

}
