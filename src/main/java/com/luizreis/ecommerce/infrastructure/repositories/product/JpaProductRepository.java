package com.luizreis.ecommerce.infrastructure.repositories.product;

import com.luizreis.ecommerce.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.category")
    List<ProductEntity> findAllProducts();

    @Query("SELECT p FROM ProductEntity p JOIN FETCH p.category WHERE p.category.id =:categoryId")
    List<ProductEntity> findAllProductsByCategoryId(Long categoryId);
}
