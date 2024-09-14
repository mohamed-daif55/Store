package com.its.store.service.mapper;

import com.its.store.model.CategoryModel;
import com.its.store.repo.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    Category toEntity(CategoryModel categoryModel);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    CategoryModel toModel(Category category);

}
