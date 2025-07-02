package com.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Purchase;
import com.dao.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    void addPurchase(Purchase purchase){
        purchaseRepository.save(purchase);
    }

    List<Purchase> getPurchaseBetween(LocalDateTime start, LocalDateTime end){
        List<Purchase> purchases = purchaseRepository.findByPurchaseDateTimeBetween(start, end);
        return purchases;
    }
    List<Purchase> getPurchaseByCategory(String category){
        List<Purchase> purchases = purchaseRepository.findByPurchaseProduct_ProductCategory(category);
        return purchases;
    }   

}
