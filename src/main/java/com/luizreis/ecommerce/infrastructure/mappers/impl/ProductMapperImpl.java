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
        CategoryEntity categoryEntity = categoryMapper.modelToEntity(product.getCategory());
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
}
