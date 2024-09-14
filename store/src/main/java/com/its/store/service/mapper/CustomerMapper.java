package com.its.store.service.mapper;

import com.its.store.model.CustomerModel;
import com.its.store.model.OrderModel;
import com.its.store.repo.entity.Customer;
import com.its.store.repo.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {OrderMapper.class})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "orderModel", target = "orders")
    })
    Customer toEntity(CustomerModel customerModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "orders", target = "orderModel")
    })
    CustomerModel toModel(Customer customer);

   /* @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "totalAmmount", target = "totalAmmount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "customerModel", target = "customer"),
            @Mapping(source = "productModel", target = "product"),
            @Mapping(source = "merchantModel", target = "merchant")
    })
    Order toEntity(OrderModel orderModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "totalAmmount", target = "totalAmmount"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "customer", target = "customerModel"),
            @Mapping(source = "product", target = "productModel"),
            @Mapping(source = "merchant", target = "merchantModel")
    })
    OrderModel toModel(Order order);*/

}
