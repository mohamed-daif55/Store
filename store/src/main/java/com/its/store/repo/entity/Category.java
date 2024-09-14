package com.its.store.repo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name ="category")@DynamicUpdate //update the changed field only in update statement
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "category")
    private List<Merchant> merchant;

}
