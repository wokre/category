package com.shop.category.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shop.category.domain.Category;
import com.shop.category.domain.QCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.shop.category.domain.QCategory.category;

/**
 * Created By bohyun on 2021/12/15
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom{

    private final EntityManager em;
    private final JPAQueryFactory query;

    public CategoryRepositoryImpl(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    @Override
    public List<Category> findById(int parentId) {
        List<Category> categories = query.select(category)
                .from(category)
                .where(findParent(parentId)).fetch();
        return categories;
    }

    private BooleanExpression findParent(int parentId) {
        if (parentId > 0) {
            return category.parent.id.eq(parentId);
        }
        return null;
    }
}
