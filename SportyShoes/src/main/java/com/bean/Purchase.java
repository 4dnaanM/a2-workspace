package com.bean;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId; 
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User purchaseUser;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product purchaseProduct;
	private LocalDateTime purchaseDateTime; 
	private int purchaseQuantity;
	private double purchaseTotalPrice;
	
	public Purchase() {}
	
	public Purchase(int id, User user, Product product, LocalDateTime dateTime,
			int quantity, double totalPrice) {
		super();
		this.purchaseId = id;
		this.purchaseUser = user;
		this.purchaseProduct = product;
		this.purchaseDateTime = dateTime;
		this.purchaseQuantity = quantity;
		this.purchaseTotalPrice = totalPrice;
	}
	
	public int getPurchaseId() {
		return purchaseId;
	}
	
	public User getPurchaseUser() {
		return purchaseUser;
	}
	
	public Product getPurchaseProduct() {
		return purchaseProduct;
	}
	
	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}
	
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	
	public double getTotalPrice() {
		return purchaseTotalPrice;
	}
	
	protected void setPurchaseUser(User purchaseUser) {
		this.purchaseUser = purchaseUser;
	}
	
	protected void setPurchaseProduct(Product purchaseProduct) {
		this.purchaseProduct = purchaseProduct;
	}
	
	protected void setPurchaseDateTime(LocalDateTime purchaseDateTime) {
		this.purchaseDateTime = purchaseDateTime;
	}
	
	protected void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	protected void setTotalPrice(double totalPrice) {
		this.purchaseTotalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", purchaseUser=" + purchaseUser + ", purchaseProduct="
				+ purchaseProduct + ", purchaseDateTime=" + purchaseDateTime + ", purchaseQuantity=" + purchaseQuantity
				+ ", purchaseTotalPrice=" + purchaseTotalPrice + "]";
	} 
	
}
