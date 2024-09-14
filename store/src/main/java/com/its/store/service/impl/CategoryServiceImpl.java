package com.its.store.service.impl;

import com.its.store.model.CategoryModel;
import com.its.store.repo.entity.Category;
import com.its.store.repo.entity.CategoryRepository;
import com.its.store.service.CategoryService;
import com.its.store.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j//used to enable log on this class level
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;


    @Override
    public List<CategoryModel> list() {
        List<Category> list = categoryRepository.findAll();
        log.info("category list retrived successfully");
        return list.stream().map(categoryMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryModel> findById(Long id) {
        Optional<Category> category = Optional.of(categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("non category fould with this id : " + id )));
        return  category.stream().map(categoryMapper::toModel).findFirst();
    }

    @Override
    public Optional<CategoryModel> add(CategoryModel categoryModel) {
        Category entity = categoryMapper.toEntity(categoryModel);
        Category savedCategory = categoryRepository.save(entity);
        log.info("category saved successfully");
        return Optional.of(categoryMapper.toModel(savedCategory));
    }

    @Override
    public Optional<CategoryModel> update(Long id, CategoryModel categoryModel) {
        if(!categoryRepository.existsById(id)){
            log.error("No category found with this id: " + id);
            throw new RuntimeException("No category found with this id: " + id);
        }

        Category category = categoryMapper.toEntity(categoryModel);
        category.setId(id);
        Category update = categoryRepository.save(category);
        return Optional.of(categoryMapper.toModel(update));
    }

    @Override
    public Optional<Boolean> delete(Long id) {
        if(!categoryRepository.existsById(id)){
            log.error("No category found with this id: " + id);
            return Optional.of(Boolean.FALSE);
        }
        categoryRepository.deleteById(id);
        return Optional.of(Boolean.TRUE);
    }
}
