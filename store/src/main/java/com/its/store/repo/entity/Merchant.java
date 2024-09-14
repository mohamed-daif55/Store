package com.its.store.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name ="merchant")@DynamicUpdate //update the changed field only in update statement
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "merchant_product", // Name of the join table
            joinColumns = @JoinColumn(name = "merchant_id"), // Foreign key to the merchant table
            inverseJoinColumns = @JoinColumn(name = "product_id") // Foreign key to the Product table
    )
    private List<Product> product;

    @ManyToMany
    @JoinTable(
            name = "merchant_category", // Name of the join table
            joinColumns = @JoinColumn(name = "merchant_id"), // Foreign key to the merchant table
            inverseJoinColumns = @JoinColumn(name = "category_id") // Foreign key to the category table
    )
    private List<Category> category;

}
