package com.luizreis.ecommerce.infrastructure.repositories.customer;

import com.luizreis.ecommerce.adapters.customer.CreateCustomerAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByEmailAdapter;
import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public class CustomerRepository implements CreateCustomerAdapter, CustomerExistsByEmailAdapter {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerMapper mapper;

    public CustomerRepository(JpaCustomerRepository jpaCustomerRepository, CustomerMapper mapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaCustomerRepository.findByEmail(email) != null;
    }

    @Override
    public Customer create(Customer customer) {
        customer.setCreatedAt(Instant.now());
        CustomerEntity entity = jpaCustomerRepository.save(mapper.modelToEntity(customer));
        return mapper.entityToModel(entity);
    }
}
