package com.luizreis.ecommerce.infrastructure.config;

import com.luizreis.ecommerce.adapters.customer.CustomerExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.order.CreateOrderAdapter;
import com.luizreis.ecommerce.adapters.product.GetProductByIdAdapter;
import com.luizreis.ecommerce.application.usecases.order.CreateOrderUseCaseImpl;
import com.luizreis.ecommerce.core.usecases.order.CreateOrderUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public CreateOrderUseCase createOrderUseCase(CustomerExistsByIdAdapter customerExistsByIdAdapter, GetProductByIdAdapter getProductByIdAdapter, CreateOrderAdapter createOrderAdapter){
        return new CreateOrderUseCaseImpl(customerExistsByIdAdapter, getProductByIdAdapter, createOrderAdapter);
    }
}
