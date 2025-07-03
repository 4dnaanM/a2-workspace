package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    List<Purchase> findByPurchaseDateTimeBetween(LocalDate start, LocalDate end);
    List<Purchase> findByPurchaseDateTime(LocalDate day);
    List<Purchase> findByPurchaseProduct_ProductCategory(String category);
    List<Purchase> findByPurchaseUser_UserId(int id);
}
