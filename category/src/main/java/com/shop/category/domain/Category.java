package com.shop.category.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private int id;

    private String name;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "parent_id")
    @JsonManagedReference
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = ALL)
    @JsonBackReference
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

    public void changeName(String name) {
        this.name = name;
    }
}
