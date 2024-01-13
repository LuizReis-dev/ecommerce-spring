package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.infrastructure.api.dtos.ProductRequest;
import com.luizreis.ecommerce.infrastructure.entities.ProductEntity;

public interface ProductMapper {

    ProductEntity modelToEntity(Product product);
    Product requestToModel(ProductRequest request);
}
