package com.luizreis.ecommerce.infrastructure.repositories.category;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByNameAdapter;
import com.luizreis.ecommerce.adapters.category.CreateCategoryAdapter;
import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.infrastructure.entities.CategoryEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepository implements CreateCategoryAdapter, CategoryExistsByNameAdapter {

    private final JpaCategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryRepository(JpaCategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean existsByName(String name) {
        return repository.findByName(name) != null;
    }

    @Override
    public void create(Category category) {
        repository.save(mapper.modelToEntity(category));
    }
}
