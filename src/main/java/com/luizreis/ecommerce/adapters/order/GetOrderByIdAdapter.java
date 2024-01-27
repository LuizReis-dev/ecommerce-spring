package com.luizreis.ecommerce.adapters.order;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.Payment;

public interface GetOrderByIdAdapter {

    Order getOrderByPayment (Long id);
}
