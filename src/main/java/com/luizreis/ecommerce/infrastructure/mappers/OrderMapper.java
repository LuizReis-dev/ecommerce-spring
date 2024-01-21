package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderResponse;
import com.luizreis.ecommerce.infrastructure.entities.OrderEntity;

public interface OrderMapper {

    Order entityToModel(OrderEntity entity);
    OrderEntity modelToEntity(Order order);

    OrderResponse modelToResponse(Order order);
}
