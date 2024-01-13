package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.product.CreateProductAdapter;
import com.luizreis.ecommerce.application.usecases.product.CreateProductUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.product.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(CategoryExistsByIdAdapter categoryExistsByIdAdapter, CreateProductAdapter createProductAdapter){
        return new CreateProductUseCaseImpl(categoryExistsByIdAdapter, createProductAdapter);
    }
}
