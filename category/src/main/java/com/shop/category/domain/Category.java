package com.shop.category.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

/**
 * Created By bohyun on 2021/12/15
 */
@Entity
@Getter @Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    private String name;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = ALL)
    private List<Category> child = new ArrayList<>();

    public static Category createCategory(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

    public void updateCategory(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }
}
