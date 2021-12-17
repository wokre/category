package com.shop.category.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created By bohyun on 2021/12/15
 */
@Data
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private int parentId;
}
