package com.its.store.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name ="product")@DynamicUpdate //update the changed field only in update statement
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(mappedBy = "product")
    private List<Orders> orders;

    @ManyToMany(mappedBy = "product")
    private List<Merchant> merchant;

}
