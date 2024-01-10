package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.infrastructure.api.dtos.CategoryRequest;
import com.luizreis.ecommerce.infrastructure.entities.CategoryEntity;

public interface CategoryMapper {

    CategoryEntity modelToEntity(Category category);
    Category requestToModel(CategoryRequest request);
}
