package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.product.CreateProductAdapter;
import com.luizreis.ecommerce.adapters.product.GetAllProductsAdapter;
import com.luizreis.ecommerce.application.usecases.product.CreateProductUseCaseImpl;
import com.luizreis.ecommerce.application.usecases.product.GetAllProductUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.product.CreateProductUseCase;
import com.luizreis.ecommerce.core.usecases.product.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(CategoryExistsByIdAdapter categoryExistsByIdAdapter, CreateProductAdapter createProductAdapter){
        return new CreateProductUseCaseImpl(categoryExistsByIdAdapter, createProductAdapter);
    }

    public GetAllProductsUseCase getAllProductsUseCase(GetAllProductsAdapter getAllProductsAdapter){
        return new GetAllProductUseCaseImpl(getAllProductsAdapter);
    }
}
