package com.its.store.service;

import com.its.store.model.MerchantModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MerchantService {

    List<MerchantModel> list();

    Optional<MerchantModel> findById(Long id);

    Optional<MerchantModel> findByName(String name);

    Page<MerchantModel> list(Pageable pageable);

    Optional<MerchantModel> add(MerchantModel merchantModel);

    Optional<MerchantModel> update(Long id, MerchantModel merchantModel);
    Optional<Boolean> delete(Long id);

}
