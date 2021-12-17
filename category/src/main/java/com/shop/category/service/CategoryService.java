package com.shop.category.service;

import com.shop.category.domain.Category;
import com.shop.category.domain.CategoryDto;
import com.shop.category.repository.CategoryRepository;
import com.shop.category.repository.CategoryRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created By bohyun on 2021/12/15
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepositoryImpl categoryRepositoryImpl;

    private final CategoryRepository categoryRepository;

    public List<Category> list(int categoryId) {
        List<Category> categories = categoryRepositoryImpl.findById(categoryId);
        return categories;
    }

    public Category save(CategoryDto dto) {
        Category parentCategory = categoryRepository.findById(dto.getParentId()).orElse(null);
        Category category = new Category();
        category.setName(dto.getName());
        category.setParent(parentCategory);

        Category save = categoryRepository.save(category);
        return save;
    }

    public Category update(int categoryId, CategoryDto dto) {
        Category category = categoryRepository.findById(categoryId).get();
        Category parent = categoryRepository.findById(dto.getParentId()).get();
        category.updateCategory(dto.getName(), parent);

        return category;
    }

    public void delete(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
