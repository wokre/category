package com.shop.category.repository;

import com.shop.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By bohyun on 2021/12/15
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
