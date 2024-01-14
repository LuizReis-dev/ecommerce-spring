package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.customer.CreateCustomerAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByEmailAdapter;
import com.luizreis.ecommerce.application.usecases.customer.CreateCustomerUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.customer.CreateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public CreateCustomerUseCase createCustomerUseCase(CreateCustomerAdapter createCustomerAdapter, CustomerExistsByEmailAdapter customerExistsByEmailAdapter){
        return new CreateCustomerUseCaseImpl(createCustomerAdapter, customerExistsByEmailAdapter);
    }
}
