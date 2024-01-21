package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.OrderItem;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderItemRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderItemResponse;
import com.luizreis.ecommerce.infrastructure.entities.OrderItemEntity;

public interface OrderItemMapper {

    OrderItem requestToEntity(OrderItemRequest request);
    OrderItem entityToModel(OrderItemEntity entity);
    OrderItemEntity modelToEntity(OrderItem model);
    OrderItemResponse modelToResponse(OrderItem model);
}
