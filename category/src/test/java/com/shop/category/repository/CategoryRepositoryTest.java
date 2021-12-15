package com.shop.category.repository;

import com.shop.category.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created By bohyun on 2021/12/15
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void testCategory() {
        Category category = new Category();
        category.setName("hi");

        int id = categoryRepository.save(category).getId();
        Category findCategory = categoryRepository.findById(id).get();

        Assertions.assertThat(category.getName()).isEqualTo(findCategory.getName());
//        Assertions.assertThat(category).isEqualTo(findCategory);
//        Assertions.assertThat(findCategory.getParent()).isNotNull();
        System.out.println(findCategory);
    }
}