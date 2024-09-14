package com.its.store.repo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_product")
public class OrderProduct {

//    @EmbeddedId
//    private OrderProductId id;

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "product_id")
    private Long productId;

//    @ManyToOne
//    //@MapsId("orderId")
//    @JoinColumn(name = "product")
//    private Orders orders;
//
//    @ManyToOne
//    //@MapsId("productId")
//    @JoinColumn(name = "orders")
//    private Product product;

    // Additional fields here
}
