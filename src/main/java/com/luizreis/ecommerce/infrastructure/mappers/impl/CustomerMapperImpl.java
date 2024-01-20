package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Address;
import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.AddressEntity;
import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import com.luizreis.ecommerce.infrastructure.mappers.AddressMapper;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    private final AddressMapper addressMapper;

    public CustomerMapperImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public CustomerEntity modelToEntity(Customer customer) {

        AddressEntity addressEntity = null;
        if(customer.getAddress() != null) {
            addressEntity = addressMapper.modelToEntity(customer.getAddress());
        }
        return new CustomerEntity(customer.getId(),customer.getFullName(), customer.getEmail(), customer.getPhoneNumber(),customer.getCreatedAt(), addressEntity);
    }

    @Override
    public Customer entityToModel(CustomerEntity entity) {
        return new Customer(entity.getId(), entity.getFullName(), entity.getEmail(), entity.getPhoneNumber(), entity.getCreatedAt());
    }
}
