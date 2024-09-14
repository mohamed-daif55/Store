package com.its.store.service;

import com.its.store.model.ProductModel;
import com.its.store.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductModel> list();

    Page<ProductModel> groupByCaegory(Long merchantId,Pageable pageable);

    Optional<ProductModel> findById(Long id);

    Optional<ProductModel> findByName(String name);

    Optional<ProductModel> findBySku(String sku);

    Page<ProductModel> list(Pageable pageable);

    Optional<ProductModel> add(ProductModel productModel);

    Optional<ProductModel> update(Long id, ProductModel productModel);
    Optional<Boolean> delete(Long id);

}
