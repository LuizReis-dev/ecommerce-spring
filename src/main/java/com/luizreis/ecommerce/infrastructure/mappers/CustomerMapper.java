package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;

public interface CustomerMapper {
    CustomerEntity modelToEntity(Customer customer);
    Customer entityToModel(CustomerEntity entity);
}
