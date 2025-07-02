package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    List<Product> findByProductNameContaining(String name);
    
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.productCategory = :category WHERE p.productId = :productId")
    int updateProductCategory(@Param("productId") int productId, @Param("category") String productCategory);
}
