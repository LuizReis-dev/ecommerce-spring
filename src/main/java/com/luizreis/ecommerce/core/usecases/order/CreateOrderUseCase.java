package com.luizreis.ecommerce.core.usecases.order;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.OrderItem;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.ProductNotFoundException;

import java.util.List;

public interface CreateOrderUseCase {

    Order create(List<OrderItem> orderItems, Customer customer) throws CustomerNotFoundException, ProductNotFoundException;
}
