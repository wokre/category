package com.shop.category.repository;

import com.shop.category.domain.Category;

import java.util.List;

/**
 * Created By bohyun on 2021/12/16
 */
public interface CategoryRepositoryCustom {
    List<Category> findById(int parentI);
}
