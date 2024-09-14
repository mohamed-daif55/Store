package com.its.store.service;

import com.its.store.model.CategoryModel;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryModel> list();

    Optional<CategoryModel> findById(Long id);

    Optional<CategoryModel> add(CategoryModel categoryModel);

    Optional<CategoryModel> update(Long id, CategoryModel categoryModel);

    Optional<Boolean> delete(Long id);

}
