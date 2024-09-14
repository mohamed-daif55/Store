package com.its.store.service.impl;

import com.its.store.model.CustomerModel;
import com.its.store.repo.entity.Customer;
import com.its.store.repo.entity.CustomerRepository;
import com.its.store.service.CustomerService;
import com.its.store.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j//used to enable log on this class level
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerModel> list() {
        List<Customer> list = customerRepository.findAll();
        log.info("customers list retrived successfully");
        return list.stream().map(customerMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<CustomerModel> custome() {
        List<Customer> list = customerRepository.custom();
        return list.stream().map(customerMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerModel> findById(Long id) {
        Optional<Customer> customer = Optional.of(customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("non customer fould with this id : " + id )));
        return  customer.stream().map(customerMapper::toModel).findFirst();
    }

    @Override
    public Optional<CustomerModel> findByName(String name) {
        Optional<Customer> customer = Optional.of(customerRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("non customer found with this name : " + name )));
        return  customer.stream().map(customerMapper::toModel).findFirst();
    }

    @Override
    public Page<CustomerModel> list(Pageable pageable) {
        Page<Customer> list = customerRepository.findAll(pageable);
        List<CustomerModel> model =  list.stream().map(customerMapper::toModel).collect(Collectors.toList());
        return new PageImpl<>(model, pageable, list.getTotalElements());
    }

    @Override
    public Optional<CustomerModel> add(CustomerModel customerModel) {
        Customer entity = customerMapper.toEntity(customerModel);
        Customer savedCustomer = customerRepository.save(entity);
        log.info("customer saved successfully");
        return Optional.of(customerMapper.toModel(savedCustomer));
    }

    @Override
    public Optional<CustomerModel> update(Long id, CustomerModel customerModel) {
        if(!customerRepository.existsById(id)){
            log.error("No customer found with this id: " + id);
            throw new RuntimeException("No customer found with this id: " + id);
        }

        Customer customer = customerMapper.toEntity(customerModel);
        customer.setId(id);
        Customer update = customerRepository.save(customer);
        return Optional.of(customerMapper.toModel(update));
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        if(!customerRepository.existsById(id)){
            log.error("No customer found with this id: " + id);
            return Optional.of(Boolean.FALSE);
        }
        customerRepository.deleteById(id);
        return Optional.of(Boolean.TRUE);
    }
}
