package com.shop.category.controller;

import com.shop.category.domain.Category;
import com.shop.category.domain.CategoryDto;
import com.shop.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created By bohyun on 2021/12/16
 */
@RestController
@RequestMapping(value = "/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(value = "/list")
    public List<Category> categories(@RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId) {
        return categoryService.list(categoryId);
    }

    @PostMapping(value = "/save")
    public Category save(@RequestBody CategoryDto dto) {
        return categoryService.save(dto);
    }

    @PostMapping(value = "/edit/{id}")
    public Category update(@PathVariable("id") int categoryId, @RequestBody CategoryDto dto) {
        return categoryService.update(categoryId, dto.getName());
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") int categoryId) {
        categoryService.delete(categoryId);
    }
}
