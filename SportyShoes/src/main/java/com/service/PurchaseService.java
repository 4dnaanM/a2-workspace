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

    public void addPurchase(int userId, int productId, int quantity){
        Product prod = productRepository.getReferenceById(productId);
        User user = userRepository.getReferenceById(userId);
        if (user == null || prod == null) {
            return;
        }
        Purchase purchase = new Purchase(user, prod, LocalDateTime.now(), quantity, quantity*prod.getProductPrice());
        purchaseRepository.save(purchase);
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
