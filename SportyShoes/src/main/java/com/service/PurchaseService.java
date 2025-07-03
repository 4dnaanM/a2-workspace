package com.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.bean.Purchase;
import com.bean.User;
import com.dao.ProductRepository;
import com.dao.PurchaseRepository;
import com.dao.UserRepository;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public String addPurchase(int userId, int productId, int quantity){
        Product prod = productRepository.findById(productId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return "User does not exist";
        }
        if(prod == null) {
            return "Product does not exist";
        }
        Purchase purchase = new Purchase(user, prod, LocalDateTime.now(), quantity, quantity*prod.getProductPrice());
        purchaseRepository.save(purchase);
        return "Purchase added successfully";
    }

    public List<Purchase> getAllPurchases(){
        List<Purchase> purchases = purchaseRepository.findAll();
        return purchases;
    }
    
    List<Purchase> getPurchaseBetween(LocalDate start, LocalDate end){
        List<Purchase> purchases = purchaseRepository.findByPurchaseDateTimeBetween(start, end);
        return purchases;
    }

    public List<Purchase> getPurchasesOn(LocalDate date){
        List<Purchase> purchases = purchaseRepository.findByPurchaseDateTime(date);
        return purchases;
    }
    
    public List<Purchase> getPurchaseByCategory(String category){
        List<Purchase> purchases = purchaseRepository.findByPurchaseProduct_ProductCategory(category);
        return purchases;
    }  

}
