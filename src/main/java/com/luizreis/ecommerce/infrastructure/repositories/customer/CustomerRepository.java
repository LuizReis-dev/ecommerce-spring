package com.luizreis.ecommerce.infrastructure.repositories.customer;

import com.luizreis.ecommerce.adapters.customer.CreateCustomerAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByEmailAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByIdAdapter;
import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import com.luizreis.ecommerce.infrastructure.entities.UserEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import com.luizreis.ecommerce.infrastructure.security.adapters.GetCustomerByUserAdapter;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

@Repository
public class CustomerRepository implements CreateCustomerAdapter, CustomerExistsByEmailAdapter, CustomerExistsByIdAdapter, GetCustomerByUserAdapter {

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

    @Override
    public boolean existsById(UUID id) {
        return jpaCustomerRepository.existsById(id);
    }

    @Override
    public Customer getByUser(UserEntity user) {
        return mapper.entityToModel(jpaCustomerRepository.findByUserEmail(user.getEmail()));
    }
}
