package com.its.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    private Long id;

    private LocalDate date;

    private BigDecimal totalAmmount;

    private boolean status;

    private CustomerModel customerModel;

    private List<ProductModel> productModel;

    private List<MerchantModel> merchantModel;

}
