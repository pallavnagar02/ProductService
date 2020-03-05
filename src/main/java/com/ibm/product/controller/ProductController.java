package com.ibm.product.controller;

import java.net.URI;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.product.model.Product;
import com.ibm.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	/*@Autowired
	private ProductRepository productRepository;*/
	
	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		//System.out.println("ID ----- "+ id);
		return productService.getProductById(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProduct (@RequestBody Product product) {
		
		/*product.setId(5L);
		product.setName("Geyser");
		product.setPrice(5000.00);
		product.setCategory("Home Applicances");
		product.setAvailability("OUT_OF_STOCK");
		*/
		product = productService.createProduct(product);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/products/add").buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/update/{id}")
	public String updateProduct(@PathVariable Long id, @RequestBody Product product) {
		product.setId(id);
		productService.updateProduct(product);
		return "Product with Product ID" + id + "updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct (@PathVariable Long id) {
		productService.deleteProductById(id);
		return "Product with Product ID" + id + "deleted";
	}

}
