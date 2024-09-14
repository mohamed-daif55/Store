package com.its.store.resource;

import com.its.store.model.MerchantModel;
import com.its.store.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("merchants")
@RequiredArgsConstructor
public class MerchantResource {

    private final MerchantService merchantService;

    @GetMapping
    public List<MerchantModel> list(){
        return merchantService.list();
    }

    @GetMapping("id/{id}")
    public Optional<MerchantModel> findById(@PathVariable Long id){
        return merchantService.findById(id);
    }

    @GetMapping("name/{name}")
    public Optional<MerchantModel> findByName(@PathVariable String name){
        return merchantService.findByName(name);
    }

    @GetMapping("page")
    public Page<MerchantModel> list(Pageable pageable){
        return merchantService.list(pageable);
    }

    @PostMapping
    public Optional<MerchantModel> add(@RequestBody MerchantModel merchantModel){
        return merchantService.add(merchantModel);
    }

    @PutMapping
    public Optional<MerchantModel> update(@PathVariable Long id,@RequestBody MerchantModel merchantModel){
        return merchantService.update(id, merchantModel);
    }

    @DeleteMapping
    public Optional<Boolean> delete(@PathVariable Long id){
        return merchantService.delete(id);
    }

}
