package com.its.store.service.impl;

import com.its.store.model.OrderModel;
import com.its.store.repo.entity.Orders;
import com.its.store.repo.entity.OrderRepository;
import com.its.store.service.OrderService;
import com.its.store.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j//used to enable log on this class level
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;
    @Override
    public List<OrderModel> list() {
        List<Orders> list = orderRepository.findAll();
        log.info("orders list retrived successfuly");
        return list.stream().map(orderMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderModel> findById(Long id) {
        Optional<Orders> entity = orderRepository.findById(id);
        return entity.stream().map(orderMapper::toModel).findFirst();
    }

    @Override
    public List<OrderModel> findByDate(LocalDate date) {
        List<Orders> list = orderRepository.findAllByDate(date);
        return list.stream().map(orderMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Page<OrderModel> list(Pageable pageable) {
        Page<Orders> list = orderRepository.findAll(pageable);
        List<OrderModel> model =  list.stream().map(orderMapper::toModel).collect(Collectors.toList());
        return new PageImpl<>(model, pageable, list.getTotalElements());
    }

    @Override
    public Optional<OrderModel> add(OrderModel orderModel) {
        Orders entity = orderMapper.toEntity(orderModel);
        Orders saved = orderRepository.save(entity);
        log.info("order saved successfully");
        return Optional.of(orderMapper.toModel(saved));
    }

    @Override
    public Optional<OrderModel> update(Long id, OrderModel orderModel) {
        if(!orderRepository.existsById(id)){
            log.error("No order found with this id: " + id);
            throw new RuntimeException("No order found with this id: " + id);
        }
        Orders entity = orderMapper.toEntity(orderModel);
        entity.setId(id);
        Orders update  = orderRepository.save(entity);
        return  Optional.of(orderMapper.toModel(update));
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        if(!orderRepository.existsById(id)){
            log.error("No order found with this id: " + id);
            return Optional.of(Boolean.FALSE);
        }
        orderRepository.deleteById(id);
        return Optional.of(Boolean.TRUE);
    }
}
