package com.its.store.service.mapper;

import com.its.store.model.OrderModel;
import com.its.store.repo.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class, MerchantMapper.class})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "totalAmmount", target = "totalAmmount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "customerModel", target = "customer"),
            @Mapping(source = "productModel", target = "product")
            //@Mapping(source = "merchantModel", target = "merchant")
    })
    Orders toEntity(OrderModel orderModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "totalAmmount", target = "totalAmmount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "customer", target = "customerModel"),
            @Mapping(source = "product", target = "productModel")
            //@Mapping(source = "merchant", target = "merchantModel")
    })
    OrderModel toModel(Orders orders);

}
