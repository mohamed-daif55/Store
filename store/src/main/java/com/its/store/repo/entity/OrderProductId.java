package com.its.store.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderProductId implements Serializable {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    // Default constructor
    public OrderProductId() {}

    // Getters, setters, equals, and hashCode
}
