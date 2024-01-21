package com.luizreis.ecommerce.infrastructure.repositories.order;

import com.luizreis.ecommerce.infrastructure.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
