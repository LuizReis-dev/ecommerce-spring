package com.luizreis.ecommerce.application.usecases.order;

import com.luizreis.ecommerce.adapters.customer.CustomerExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.order.CreateOrderAdapter;
import com.luizreis.ecommerce.adapters.product.GetProductByIdAdapter;
import com.luizreis.ecommerce.core.domain.*;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.ProductNotFoundException;
import com.luizreis.ecommerce.core.usecases.order.CreateOrderUseCase;

import java.time.Instant;
import java.util.List;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final CustomerExistsByIdAdapter customerExistsByIdAdapter;
    private final GetProductByIdAdapter getProductByIdAdapter;
    private final CreateOrderAdapter createOrderAdapter;

    public CreateOrderUseCaseImpl(CustomerExistsByIdAdapter customerExistsByIdAdapter, GetProductByIdAdapter getProductByIdAdapter, CreateOrderAdapter createOrderAdapter) {
        this.customerExistsByIdAdapter = customerExistsByIdAdapter;
        this.getProductByIdAdapter = getProductByIdAdapter;
        this.createOrderAdapter = createOrderAdapter;
    }

    @Override
    public Order create(List<OrderItem> orderItems, Customer customer) throws CustomerNotFoundException, ProductNotFoundException {

        if(!customerExistsByIdAdapter.existsById(customer.getId()))
            throw new CustomerNotFoundException("Customer not found! ID: " + customer.getId());

        for (OrderItem orderItem : orderItems) {
            Product product = getProductByIdAdapter.getById(orderItem.getProduct().getId());

            if(product == null)
                throw new ProductNotFoundException("Product not found! ID: " + orderItem.getProduct().getId());

            orderItem.setTotal(product.getPrice() * orderItem.getQuantity());

        }

        Order order = new Order();
        order.setOrderItems(orderItems);
        order.setCustomer(customer);
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        return createOrderAdapter.create(order);
    }
}
