package com.ibm.product.service;

import org.springframework.validation.annotation.Validated;

import com.ibm.product.model.Product;

@Validated
public interface ProductService {
	
    Iterable<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);
    
    void updateProduct(Product product);
    
    void deleteProductById(Long id);
}
