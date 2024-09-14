package com.its.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantModel {

    private Long id;

    private String name;

    private String phone;

}
