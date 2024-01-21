package com.luizreis.ecommerce.infrastructure.repositories.customer;

import com.luizreis.ecommerce.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    CustomerEntity findByEmail(String email);

    @Query("SELECT c FROM CustomerEntity c JOIN FETCH c.user u WHERE u.email =:email")
    CustomerEntity findByUserEmail(String email);
}
