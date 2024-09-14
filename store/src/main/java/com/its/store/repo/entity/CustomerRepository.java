package com.its.store.repo.entity;

import com.its.store.repo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c order by c.id desc")
    List<Customer> custom();

    Optional<Customer> findByName(String name);

}
