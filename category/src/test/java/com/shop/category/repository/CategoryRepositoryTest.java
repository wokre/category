package com.shop.category.repository;

import com.shop.category.CategoryApplication;
import com.shop.category.domain.Category;
import com.shop.category.domain.CategoryDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created By bohyun on 2021/12/15
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryRepositoryImpl categoryRepositoryImpl;

    @Test
    @Transactional
    void testCategory() {
        Category category = new Category();
        category.setName("hi");

        Category child = new Category();
        child.setName("hi child");

        category.addChildCategory(child);

        int id = categoryRepository.save(category).getId();
        Category findCategory = categoryRepository.findById(id).get();
        Assertions.assertThat(category.getName()).isEqualTo(findCategory.getName());
    }

    @Test
    @Transactional
    void getCategory() {
        List<Category> categories = categoryRepositoryImpl.findById(13);
//        Category category = categoryRepository.findByParent_Id(13);

        Map<Category, List<Category>> collect = categories.stream().collect(Collectors.groupingBy(Category::getParent));
        System.out.println(collect);

        Assertions.assertThat(categories).isNotNull();
        System.out.println("category list size : " + categories.size());
    }

    @Test
    @Transactional
    void updateCategory() {
        Category category = categoryRepository.findById(1).get();
        category.setName("testtest");

        Category category1 = categoryRepository.findById(1).get();
        Assertions.assertThat(category.getName()).isEqualTo(category1.getName());
    }
}