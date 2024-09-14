package com.its.store.resource;

import com.its.store.model.CategoryModel;
import com.its.store.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> list(){
        return categoryService.list();
    }

    @GetMapping("{id}")
    public Optional<CategoryModel> findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public Optional<CategoryModel> add(@RequestBody CategoryModel categoryModel){
        return categoryService.add(categoryModel);
    }

    @PutMapping("{id}")
    public Optional<CategoryModel> update(@PathVariable Long id, @RequestBody CategoryModel categoryModel){
        return categoryService.update(id,categoryModel);
    }

    @DeleteMapping("{id}")
    public Optional<Boolean> delete(@PathVariable Long id){
        return categoryService.delete(id);
    }

}
