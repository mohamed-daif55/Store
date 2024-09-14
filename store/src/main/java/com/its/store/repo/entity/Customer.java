package com.its.store.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name ="customer")@DynamicUpdate //update the changed field only in update statement
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

}
