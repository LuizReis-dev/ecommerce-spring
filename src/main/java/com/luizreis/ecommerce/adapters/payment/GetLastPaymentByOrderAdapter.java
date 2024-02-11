package com.luizreis.ecommerce.adapters.payment;

import com.luizreis.ecommerce.core.domain.Order;
import com.luizreis.ecommerce.core.domain.Payment;

public interface GetLastPaymentByOrderAdapter {

    Payment getLastPaymentByOrder(Order order);
}
