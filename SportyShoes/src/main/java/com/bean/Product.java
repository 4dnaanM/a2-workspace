package com.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId; 
    private String productName; 
    private String productCategory;
    private float productPrice;
	
    public Product() {}
    
	public Product(int productId, String productName, String productCategory, float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}
	
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public float getProductPrice() {
		return productPrice;
	}
	
	protected void setProductName(String productName) {
		this.productName = productName;
	}
	
	protected void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	protected void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + "]";
	}
    
}
