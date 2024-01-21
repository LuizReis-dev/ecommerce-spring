package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.OrderItem;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderItemRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderItemResponse;
import com.luizreis.ecommerce.infrastructure.entities.OrderEntity;
import com.luizreis.ecommerce.infrastructure.entities.OrderItemEntity;
import com.luizreis.ecommerce.infrastructure.mappers.OrderItemMapper;
import com.luizreis.ecommerce.infrastructure.mappers.OrderMapper;
import com.luizreis.ecommerce.infrastructure.mappers.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    private final ProductMapper productMapper;
    public OrderItemMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public OrderItem requestToEntity(OrderItemRequest request) {
        OrderItem orderItem = new OrderItem();
        Product product = new Product();
        product.setId(request.getProductId());
        orderItem.setProduct(product);
        orderItem.setQuantity(request.getQuantity());
        return orderItem;
    }

    @Override
    public OrderItem entityToModel(OrderItemEntity entity) {
        OrderItem orderItem = new OrderItem();
        Order order = new Order();
        order.setId(entity.getId());
        orderItem.setOrder(order);
        orderItem.setProduct(productMapper.entityToModel(entity.getProduct()));
        orderItem.setTotal(entity.getTotal());
        orderItem.setQuantity(entity.getQuantity());

        return orderItem;
    }

    @Override
    public OrderItemEntity modelToEntity(OrderItem model) {
        OrderItemEntity entity = new OrderItemEntity();

        OrderEntity order = new OrderEntity();
        order.setId(entity.getId());
        entity.setOrder(order);

        entity.setProduct(productMapper.modelToEntity(model.getProduct()));
        entity.setQuantity(model.getQuantity());
        entity.setTotal(model.getTotal());

        return entity;
    }

    @Override
    public OrderItemResponse modelToResponse(OrderItem model) {
        return new OrderItemResponse(model.getProduct().getId(), model.getQuantity(), model.getTotal());
    }
}
