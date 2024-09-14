package com.its.store.repo.entity;

import com.its.store.model.ProductModel;
import com.its.store.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Optional<Product> findBySku(String sku);

    @Query("SELECT p FROM Product p JOIN p.merchant m JOIN m.category c WHERE m.id = :merchantId")
    Page<Product> groupByCaegory(@Param("merchantId") Long merchantId, Pageable pageable);

}
