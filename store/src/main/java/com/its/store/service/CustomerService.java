package com.its.store.service;

import com.its.store.model.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerModel> list();

    List<CustomerModel> custome();

    Optional<CustomerModel> findById(Long id);

    Optional<CustomerModel> findByName(String name);

    Page<CustomerModel> list(Pageable pageable);

    Optional<CustomerModel> add(CustomerModel customerModel);

    Optional<CustomerModel> update(Long id, CustomerModel customerModel);
    Optional<Boolean> delete(Long id);
}
