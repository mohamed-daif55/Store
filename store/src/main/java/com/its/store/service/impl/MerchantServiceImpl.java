package com.its.store.service.impl;

import com.its.store.model.MerchantModel;
import com.its.store.repo.entity.Merchant;
import com.its.store.repo.entity.MerchantRepository;
import com.its.store.service.MerchantService;
import com.its.store.service.mapper.MerchantMapper;
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
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;
    @Override
    public List<MerchantModel> list() {
        List<Merchant> list = merchantRepository.findAll();
        log.info("merchants list retrived successfully");
        return list.stream().map(merchantMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<MerchantModel> findById(Long id) {
        Optional<Merchant> merchant = merchantRepository.findById(id);
        return merchant.stream().map(merchantMapper::toModel).findFirst();
    }

    @Override
    public Optional<MerchantModel> findByName(String name) {
        Optional<Merchant> merchant = merchantRepository.findAllByName(name);
        return merchant.stream().map(merchantMapper::toModel).findFirst();
    }

    @Override
    public Page<MerchantModel> list(Pageable pageable) {
        Page<Merchant> list = merchantRepository.findAll(pageable);
        List<MerchantModel> model =  list.stream().map(merchantMapper::toModel).collect(Collectors.toList());
        return new PageImpl<>(model, pageable, list.getTotalElements());
    }

    @Override
    public Optional<MerchantModel> add(MerchantModel merchantModel) {
        Merchant entity = merchantMapper.toEntity(merchantModel);
        Merchant saveedMerchant = merchantRepository.save(entity);
        log.info("merchant saved successfully");
        return Optional.of(merchantMapper.toModel(saveedMerchant));
    }

    @Override
    public Optional<MerchantModel> update(Long id, MerchantModel merchantModel) {
        if(!merchantRepository.existsById(id)){
            log.error("No merchant found with this id: " + id);
            throw new RuntimeException("No merchant found with this id: " + id);
        }
        Merchant entity = merchantMapper.toEntity(merchantModel);
        entity.setId(id);
        Merchant update  = merchantRepository.save(entity);
        return  Optional.of(merchantMapper.toModel(update));
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        if(!merchantRepository.existsById(id)){
            log.error("No merchant found with this id: " + id);
            return Optional.of(Boolean.FALSE);
        }
        merchantRepository.deleteById(id);
        return Optional.of(Boolean.TRUE);
    }
}
