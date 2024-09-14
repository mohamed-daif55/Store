package com.its.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    private Long id;

    private String name;

    private String phone;

    private List<OrderModel> orderModel;

}
