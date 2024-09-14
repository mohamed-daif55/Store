package com.its.store.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name ="orders")@DynamicUpdate //update the changed field only in update statement
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total_amount")
    private BigDecimal totalAmmount;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_product", // Name of the join table
            joinColumns = @JoinColumn(name = "order_id"), // Foreign key to the Order table
            inverseJoinColumns = @JoinColumn(name = "product_id") // Foreign key to the Product table
    )
    private List<Product> product;

    @ManyToMany
    @JoinTable(
            name = "merchant_product", // Name of the join table
            joinColumns = @JoinColumn(name = "merchant_id"), // Foreign key to the merchant table
            inverseJoinColumns = @JoinColumn(name = "product_id") // Foreign key to the Product table
    )
    private List<Merchant> merchant;

}
