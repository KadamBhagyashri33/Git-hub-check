package com.orderService.orderservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "productservice", url = "http://localhost:8080/")
public interface ProductClient {

	@GetMapping(value = "/products")
	public String getAllProducts();

	@GetMapping("/products/{id}")
	public String getProductById(@PathVariable(value = "id") Long id);

	@DeleteMapping("admin/products/{id}")
	public String deleteProductById(@PathVariable(value = "id") Long id);

	@PostMapping("admin/products")
	public String addProduct(@RequestBody String productFromOrder);
}
