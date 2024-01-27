package com.luizreis.ecommerce.adapters.payment;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.Payment;

public interface GetPaymentByOrderAdapter {

    Payment getPaymentByOrder(Order order);
}
