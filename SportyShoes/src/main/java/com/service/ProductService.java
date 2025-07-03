package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public String addProduct(String productName, String productCategory, float productPrice) {
		Product product = new Product(productName, productCategory, productPrice);
		productRepository.save(product);
		return "Product added successfully";
	}
	
	public String updateProductCategory(int id, String category) {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			return "Product does not exist";
		}
		productRepository.updateProductCategory(id,category);
		return "Product updated successfully";
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
}
