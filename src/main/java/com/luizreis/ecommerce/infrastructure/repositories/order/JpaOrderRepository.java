package com.luizreis.ecommerce.infrastructure.repositories.order;

import com.luizreis.ecommerce.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
