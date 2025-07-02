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
	
	public String addProduct(Product product) {
		productRepository.save(product);
		return "";
	}
	
	public String updateProductCategory(int id, String category) {
		Product product = productRepository.findById(id).orElse(null);
		if (product != null) {
			productRepository.updateProductCategory(id,category);
		}
		return "";
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
}
