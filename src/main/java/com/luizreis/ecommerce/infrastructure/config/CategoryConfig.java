package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByNameAdapter;
import com.luizreis.ecommerce.adapters.category.CreateCategoryAdapter;
import com.luizreis.ecommerce.application.usecases.category.CreateCategoryUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.category.CreateCategoryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(CategoryExistsByNameAdapter categoryExistsByNameAdapter, CreateCategoryAdapter createCategoryAdapter){
        return new CreateCategoryUseCaseImpl(categoryExistsByNameAdapter,  createCategoryAdapter);
    }
}
