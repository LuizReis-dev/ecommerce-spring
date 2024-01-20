package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.product.CreateProductAdapter;
import com.luizreis.ecommerce.adapters.product.GetAllProductsAdapter;
import com.luizreis.ecommerce.adapters.product.GetProductsByCategoryIdAdapter;
import com.luizreis.ecommerce.application.usecases.product.CreateProductUseCaseImpl;
import com.luizreis.ecommerce.application.usecases.product.GetAllProductUseCaseImpl;
import com.luizreis.ecommerce.application.usecases.product.GetProductsByCategoryIdUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.product.CreateProductUseCase;
import com.luizreis.ecommerce.core.usecases.product.GetAllProductsUseCase;
import com.luizreis.ecommerce.core.usecases.product.GetProductsByCategoryIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public CreateProductUseCase createProductUseCase(CategoryExistsByIdAdapter categoryExistsByIdAdapter, CreateProductAdapter createProductAdapter){
        return new CreateProductUseCaseImpl(categoryExistsByIdAdapter, createProductAdapter);
    }

    @Bean
    public GetAllProductsUseCase getAllProductsUseCase(GetAllProductsAdapter getAllProductsAdapter){
        return new GetAllProductUseCaseImpl(getAllProductsAdapter);
    }
    @Bean
    public GetProductsByCategoryIdUseCase getProductsByCategoryIdUseCase(GetProductsByCategoryIdAdapter getProductsByCategoryIdAdapter){
        return new GetProductsByCategoryIdUseCaseImpl(getProductsByCategoryIdAdapter);
    }

}
