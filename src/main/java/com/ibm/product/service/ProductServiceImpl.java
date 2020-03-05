package com.ibm.product.service;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.product.exception.ResourceNotFoundException;
import com.ibm.product.model.Product;
import com.ibm.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public @NotNull Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Long id) {
		
		productRepository.deleteById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
}
