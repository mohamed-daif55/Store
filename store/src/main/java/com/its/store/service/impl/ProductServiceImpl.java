package com.its.store.service.impl;

import com.its.store.model.ProductModel;
import com.its.store.repo.entity.Product;
import com.its.store.repo.entity.ProductRepository;
import com.its.store.service.ProductService;
import com.its.store.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j//used to enable log on this class level
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductModel> list() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(productMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Page<ProductModel> groupByCaegory(Long merchantId,Pageable pageable) {
        Page<Product> list = productRepository.groupByCaegory(merchantId,pageable);
        List<ProductModel> model =  list.stream().map(productMapper::toModel).collect(Collectors.toList());
        return new PageImpl<>(model, pageable, list.getTotalElements());
    }

    @Override
    public Optional<ProductModel> findById(Long id) {
        Optional<Product> entity = productRepository.findById(id);
        return entity.stream().map(productMapper::toModel).findFirst();
    }

    @Override
    public Optional<ProductModel> findByName(String name) {
        Optional<Product> entity = productRepository.findByName(name);
        return entity.stream().map(productMapper::toModel).findFirst();
    }

    @Override
    public Optional<ProductModel> findBySku(String sku) {
        Optional<Product> entity = productRepository.findBySku(sku);
        return entity.stream().map(productMapper::toModel).findFirst();
    }

    @Override
    public Page<ProductModel> list(Pageable pageable) {
        Page<Product> list = productRepository.findAll(pageable);
        List<ProductModel> model =  list.stream().map(productMapper::toModel).collect(Collectors.toList());
        return new PageImpl<>(model, pageable, list.getTotalElements());
    }

    @Override
    public Optional<ProductModel> add(ProductModel productModel) {
        Product entity = productMapper.toEntity(productModel);
        Product saved = productRepository.save(entity);
        log.info("product saved successfully");
        return Optional.of(productMapper.toModel(saved));
    }

    @Override
    public Optional<ProductModel> update(Long id, ProductModel productModel) {
        if(!productRepository.existsById(id)){
            log.error("No product found with this id: " + id);
            throw new RuntimeException("No product found with this id: " + id);
        }
        Product entity = productMapper.toEntity(productModel);
        entity.setId(id);
        Product update  = productRepository.save(entity);
        return  Optional.of(productMapper.toModel(update));
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        if(!productRepository.existsById(id)){
            log.error("No product found with this id: " + id);
            return Optional.of(Boolean.FALSE);
        }
        productRepository.deleteById(id);
        return Optional.of(Boolean.TRUE);
    }
}
