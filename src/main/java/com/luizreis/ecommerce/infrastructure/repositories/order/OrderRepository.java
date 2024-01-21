package com.luizreis.ecommerce.infrastructure.repositories.order;

import com.luizreis.ecommerce.adapters.order.CreateOrderAdapter;
import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.infrastructure.entities.OrderEntity;
import com.luizreis.ecommerce.infrastructure.entities.OrderItemEntity;
import com.luizreis.ecommerce.infrastructure.mappers.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements CreateOrderAdapter {

    private final JpaOrderRepository jpaOrderRepository;
    private final JpaOrderItemRepository jpaOrderItemRepository;
    private final OrderMapper mapper;

    public OrderRepository(JpaOrderRepository jpaOrderRepository, JpaOrderItemRepository jpaOrderItemRepository, OrderMapper mapper) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.jpaOrderItemRepository = jpaOrderItemRepository;
        this.mapper = mapper;
    }


    @Override
    public Order create(Order order) {
        OrderEntity orderEntity = mapper.modelToEntity(order);

        OrderEntity savedOrder = jpaOrderRepository.save(orderEntity);

        for(OrderItemEntity orderItemEntity : savedOrder.getItems()){
            orderItemEntity.setOrder(savedOrder);
            jpaOrderItemRepository.save(orderItemEntity);
        }


        return mapper.entityToModel(savedOrder);
    }
}
