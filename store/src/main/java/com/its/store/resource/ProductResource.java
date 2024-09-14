package com.its.store.resource;

import com.its.store.model.ProductModel;
import com.its.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public List<ProductModel> list(){
        return productService.list();
    }

    @GetMapping("groupByCategory/{merchantId}")
    public Page<ProductModel> groupByCaegory(@PathVariable Long merchantId,Pageable pageable){
        return productService.groupByCaegory(merchantId,pageable);
    }

    @GetMapping("id/{id}")
    public Optional<ProductModel> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("name/{name}")
    public Optional<ProductModel> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("sku/{sku}")
    public Optional<ProductModel> findBySku(@PathVariable String sku){
        return productService.findBySku(sku);
    }

    @GetMapping("page")
    public Page<ProductModel> list(Pageable pageable){
        return productService.list(pageable);
    }

    @PostMapping
    public Optional<ProductModel> add(@RequestBody ProductModel productModel){
        return productService.add(productModel);
    }

    @PutMapping
    public Optional<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel productModel){
        return productService.update(id, productModel);
    }

    @DeleteMapping
    public Optional<Boolean> delete(@PathVariable Long id){
        return productService.delete(id);
    }

}
