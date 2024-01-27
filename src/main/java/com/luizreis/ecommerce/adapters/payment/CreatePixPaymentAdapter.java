package com.luizreis.ecommerce.adapters.payment;

import com.luizreis.ecommerce.core.domain.Payment;
import com.luizreis.ecommerce.core.domain.PixDetails;

public interface CreatePixPaymentAdapter {

    PixDetails create(Payment payment);
}
