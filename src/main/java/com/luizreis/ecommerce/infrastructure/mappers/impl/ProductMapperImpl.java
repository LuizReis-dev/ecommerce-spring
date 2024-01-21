package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.infrastructure.api.dtos.ProductRequest;
import com.luizreis.ecommerce.infrastructure.entities.CategoryEntity;
import com.luizreis.ecommerce.infrastructure.entities.ProductEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CategoryMapper;
import com.luizreis.ecommerce.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final CategoryMapper categoryMapper;

    public ProductMapperImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ProductEntity modelToEntity(Product product) {
        CategoryEntity categoryEntity = null;
        if(product.getCategory() != null){
            categoryEntity = categoryMapper.modelToEntity(product.getCategory());
        }

        return new ProductEntity(product.getId(), product.getName(), product.getDescription(), product.getPrice(), categoryEntity, product.getCreatedAt());
    }

    @Override
    public Product requestToModel(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        Category category = new Category();
        category.setId(request.getCategoryId());

        product.setCategory(category);

        return product;

    }

    @Override
    public Product entityToModel(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setCreatedAt(entity.getCreatedAt());

        Category category = new Category();
        if(entity.getCategory() != null){
            category.setId(entity.getCategory().getId());
            category.setName(entity.getCategory().getName());
            category.setDescription(entity.getCategory().getDescription());
        }

        product.setCategory(category);

        return product;
    }
}
