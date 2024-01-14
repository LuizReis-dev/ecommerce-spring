package com.luizreis.ecommerce.infrastructure.repositories.customer;

import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    CustomerEntity findByEmail(String email);
}
