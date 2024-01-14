package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.AddressEntity;
import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerEntity modelToEntity(Customer customer) {
        return new CustomerEntity(customer.getFullName(), customer.getEmail(), customer.getPhoneNumber(),customer.getCreatedAt(), null);
    }

    @Override
    public Customer entityToModel(CustomerEntity entity) {
        return new Customer(entity.getFullName(), entity.getEmail(), entity.getPhoneNumber());
    }
}
