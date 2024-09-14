package com.its.store.service.mapper;

import com.its.store.model.ProductModel;
import com.its.store.repo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring"/*, uses = {OrderMapper.class, MerchantMapper.class}*/)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "sku", target = "sku"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "orderModel", target = "orders"),
            @Mapping(source = "merchantModel", target = "merchant")
    })
    Product toEntity(ProductModel productModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "sku", target = "sku"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "orders", target = "orderModel"),
            @Mapping(source = "merchant", target = "merchantModel")
    })
    ProductModel toModel(Product product);

}
