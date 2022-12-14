package com.productservicecatalog.productservicecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceCatalogApplication.class, args);
	}

}
