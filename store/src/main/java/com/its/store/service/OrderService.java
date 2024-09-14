package com.its.store.service;

import com.its.store.model.OrderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderModel> list();

    Optional<OrderModel> findById(Long id);

    List<OrderModel> findByDate(LocalDate date);

    Page<OrderModel> list(Pageable pageable);

    Optional<OrderModel> add(OrderModel orderModel);

    Optional<OrderModel> update(Long id, OrderModel orderModel);
    Optional<Boolean> delete(Long id);

}
