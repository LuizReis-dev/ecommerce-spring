package com.luizreis.ecommerce.infrastructure.repositories.product;

import com.luizreis.ecommerce.adapters.product.CreateProductAdapter;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.usecases.product.GetAllProductsUseCase;
import com.luizreis.ecommerce.infrastructure.entities.ProductEntity;
import com.luizreis.ecommerce.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements CreateProductAdapter, GetAllProductsUseCase {

    private final JpaProductRepository repository;
    private final ProductMapper mapper;

    public ProductRepository(JpaProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean create(Product product) {
        product.setCreatedAt(Instant.now());
        repository.save(mapper.modelToEntity(product));
        return true;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = repository.findAllProducts ();
        return productEntities
                .stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());

    }
}
