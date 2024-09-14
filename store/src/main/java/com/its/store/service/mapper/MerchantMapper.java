package com.its.store.service.mapper;

import com.its.store.model.MerchantModel;
import com.its.store.repo.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MerchantMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone", target = "phone")
    })
    Merchant toEntity(MerchantModel merchantModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone", target = "phone")
    })
    MerchantModel toModel(Merchant merchant);

}
