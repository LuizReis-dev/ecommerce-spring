package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.OrderStatus;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderItemResponse;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderResponse;
import com.luizreis.ecommerce.infrastructure.entities.OrderEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import com.luizreis.ecommerce.infrastructure.mappers.OrderItemMapper;
import com.luizreis.ecommerce.infrastructure.mappers.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {

    private final CustomerMapper customerMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderMapperImpl(CustomerMapper customerMapper, OrderItemMapper orderItemMapper) {
        this.customerMapper = customerMapper;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public Order entityToModel(OrderEntity entity) {
        Order order = new Order();
        order.setId(entity.getId());

        order.setCustomer(customerMapper.entityToModel(entity.getCustomer()));

        order.setMoment(entity.getMoment());

        order.setOrderItems(entity.getItems().stream().map(orderItemMapper::entityToModel).collect(Collectors.toList()));

        OrderStatus orderStatusDomain = OrderStatus.valueOf(String.valueOf(entity.getStatus()));
        order.setStatus(orderStatusDomain);
        return order;
    }

    @Override
    public OrderEntity modelToEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());

        entity.setCustomer(customerMapper.modelToEntity(order.getCustomer()));

        entity.setMoment(order.getMoment());
        entity.setItems(order.getOrderItems().stream().map(orderItemMapper::modelToEntity).collect(Collectors.toList()));

        com.luizreis.ecommerce.infrastructure.entities.OrderStatus orderStatusInfra = com.luizreis.ecommerce.infrastructure.entities.OrderStatus.valueOf(String.valueOf(order.getStatus()));
        entity.setStatus(orderStatusInfra);
        return entity;
    }

    @Override
    public OrderResponse modelToResponse(Order order) {
        List<OrderItemResponse> orderItemResponse = order.getOrderItems().stream().map(orderItemMapper::modelToResponse).collect(Collectors.toList());
        return new OrderResponse(order.getId(), orderItemResponse, order.getCustomer().getId(), order.getTotal(), order.getMoment());
    }
}
