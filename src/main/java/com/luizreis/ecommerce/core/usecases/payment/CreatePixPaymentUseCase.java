package com.luizreis.ecommerce.core.usecases.payment;

import com.luizreis.ecommerce.core.domain.Payment;
import com.luizreis.ecommerce.core.domain.PixDetails;
import com.luizreis.ecommerce.core.domain.exceptions.OrderDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PaymentNotAcceptedException;

public interface CreatePixPaymentUseCase {

    PixDetails create(Payment payment) throws OrderDoesntExistsException, PaymentNotAcceptedException;
}
