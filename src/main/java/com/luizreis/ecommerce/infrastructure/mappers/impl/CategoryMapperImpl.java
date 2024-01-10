package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.infrastructure.api.dtos.CategoryRequest;
import com.luizreis.ecommerce.infrastructure.entities.CategoryEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity modelToEntity(Category category) {
        return new CategoryEntity(category.getId(), category.getName(), category.getDescription());
    }

    @Override
    public Category requestToModel(CategoryRequest request) {
        return new Category(request.getName(), request.getDescription());
    }
}
