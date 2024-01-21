package com.luizreis.ecommerce.infrastructure.api.order;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.OrderItem;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.ProductNotFoundException;
import com.luizreis.ecommerce.core.usecases.order.CreateOrderUseCase;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderResponse;
import com.luizreis.ecommerce.infrastructure.mappers.OrderItemMapper;
import com.luizreis.ecommerce.infrastructure.mappers.OrderMapper;
import com.luizreis.ecommerce.infrastructure.security.usecases.GetAuthenticatedUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderControllerImpl implements OrderController{

    private final CreateOrderUseCase createOrderUseCase;
    private final GetAuthenticatedUserUseCase getLoggedUserUseCase;
    private final OrderItemMapper orderItemMapper;
    private final OrderMapper orderMapper;

    public OrderControllerImpl(CreateOrderUseCase createOrderUseCase, GetAuthenticatedUserUseCase getLoggedUserUseCase, OrderItemMapper orderItemMapper, OrderMapper orderMapper) {
        this.createOrderUseCase = createOrderUseCase;
        this.getLoggedUserUseCase = getLoggedUserUseCase;
        this.orderItemMapper = orderItemMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public ResponseEntity<OrderResponse> create(OrderRequest request) throws CustomerNotFoundException, ProductNotFoundException {

        List<OrderItem> items = request.getItems().stream().map(orderItemMapper::requestToEntity).collect(Collectors.toList());
        Customer customer = getLoggedUserUseCase.getAuthenticatedUser();


        Order order = createOrderUseCase.create(items, customer);
        return ResponseEntity.status(201).body(orderMapper.modelToResponse(order));

    }
}
