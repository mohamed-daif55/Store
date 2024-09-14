package com.its.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    private Long id;

    private String name;

    private String sku;

    private BigDecimal price;

    private int quantity;

    private List<OrderModel> orderModel;

    private List<MerchantModel> merchantModel;

}
