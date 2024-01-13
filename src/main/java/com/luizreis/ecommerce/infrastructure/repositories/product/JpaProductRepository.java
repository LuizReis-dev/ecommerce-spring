package com.luizreis.ecommerce.infrastructure.repositories.product;

import com.luizreis.ecommerce.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
