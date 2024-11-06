package com.utp.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProyectoEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEcommerceApplication.class, args);
	}

}
