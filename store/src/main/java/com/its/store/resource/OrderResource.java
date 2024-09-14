package com.its.store.resource;

import com.its.store.model.OrderModel;
import com.its.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<OrderModel> list(){
        return orderService.list();
    }

    @GetMapping("id/{id}")
    public Optional<OrderModel> findById(Long id){
        return orderService.findById(id);
    }

    @GetMapping("date/{date}")
    public List<OrderModel> findByDate(LocalDate date){
        return orderService.findByDate(date);
    }

    @GetMapping("page")
    public Page<OrderModel> list(Pageable pageable){
        return orderService.list(pageable);
    }

    @PostMapping
    public Optional<OrderModel> add(@RequestBody OrderModel orderModel){
        return orderService.add(orderModel);
    }

    @PutMapping
    public Optional<OrderModel> update(@PathVariable Long id,@RequestBody OrderModel orderModel){
        return orderService.update(id, orderModel);
    }

    @DeleteMapping
    public Optional<Boolean> delete(@PathVariable Long id){
        return orderService.delete(id);
    }

}
