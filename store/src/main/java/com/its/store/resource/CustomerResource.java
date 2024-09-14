package com.its.store.resource;

import com.its.store.model.CustomerModel;
import com.its.store.repo.entity.Customer;
import com.its.store.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerModel> list(){
        return customerService.list();
    }

    @GetMapping("custom")
    public List<CustomerModel> custome(){
        return customerService.custome();
    }

    @GetMapping("id/{id}")
    public Optional<CustomerModel> findById(@PathVariable  Long id){
        return customerService.findById(id);
    }

    @GetMapping("name/{name}")
    public Optional<CustomerModel> findByName(@PathVariable String name){
        return customerService.findByName(name);
    }

    @GetMapping("page")
    public Page<CustomerModel> list(Pageable pageable){
        return customerService.list(pageable);
    }

    @PostMapping
    public Optional<CustomerModel> add(@RequestBody CustomerModel customerModel){
        return customerService.add(customerModel);
    }

    @PutMapping("{id}")
    public Optional<CustomerModel> update(@PathVariable Long id,@RequestBody CustomerModel customerModel){
        return customerService.update(id, customerModel);
    }

    @DeleteMapping("{id}")
    public Optional<Boolean> delete(Long id){
        return customerService.delete(id);
    }

}
