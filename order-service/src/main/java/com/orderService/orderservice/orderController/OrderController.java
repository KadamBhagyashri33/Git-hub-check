package com.orderService.orderservice.orderController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderService.orderservice.feignclient.ProductClient;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private ProductClient productClient;

	@GetMapping("/orderproducts")
	public String getProductsFromProductCatalog() {
		return productClient.getAllProducts();
	}

	@GetMapping("/orderproducts/{id}")
	public String getProductsFromProductCatalogById(@PathVariable("id") Long id) {
		return productClient.getProductById(id);
	}

	@DeleteMapping("/orderproducts/{id}")
	public String deleteProductsFromProductCatalogById(@PathVariable("id") Long id) {
		return productClient.deleteProductById(id);
	}

	@PostMapping("/orderproducts")
	public String addProductstoProductCatalog(@RequestBody String productFromOrder) {
		return productClient.addProduct(productFromOrder);
	}

}
