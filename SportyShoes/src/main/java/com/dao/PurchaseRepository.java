package com.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findByPurchaseDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Purchase> findByPurchaseProduct_ProductCategory(String category);
}
