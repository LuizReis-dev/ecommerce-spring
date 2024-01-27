package com.luizreis.ecommerce.application.usecases.payment;

import com.luizreis.ecommerce.adapters.order.GetOrderByIdAdapter;
import com.luizreis.ecommerce.adapters.payment.CreatePixPaymentAdapter;
import com.luizreis.ecommerce.adapters.payment.GetPaymentByOrderAdapter;
import com.luizreis.ecommerce.core.domain.*;
import com.luizreis.ecommerce.core.domain.exceptions.OrderDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PaymentNotAcceptedException;
import com.luizreis.ecommerce.core.usecases.payment.CreatePixPaymentUseCase;

public class CreatePixPaymentUseCaseImpl implements CreatePixPaymentUseCase {

    private final CreatePixPaymentAdapter createPixPaymentAdapter;
    private final GetPaymentByOrderAdapter getPaymentByOrderAdapter;
    private final GetOrderByIdAdapter getOrderByIdAdapter;

    public CreatePixPaymentUseCaseImpl(CreatePixPaymentAdapter createPixPaymentAdapter, GetPaymentByOrderAdapter getPaymentByOrderAdapter, GetOrderByIdAdapter getOrderByIdAdapter) {
        this.createPixPaymentAdapter = createPixPaymentAdapter;
        this.getPaymentByOrderAdapter = getPaymentByOrderAdapter;
        this.getOrderByIdAdapter = getOrderByIdAdapter;
    }


    @Override
    public PixDetails create(Payment payment) throws OrderDoesntExistsException, PaymentNotAcceptedException {

        if(payment.getMethod() != PaymentMethod.PIX)
            throw new PaymentNotAcceptedException("Wrong payment method!");

        Order order = getOrderByIdAdapter.getOrderByPayment(payment.getOrder().getId());

        if(order == null)
            throw new OrderDoesntExistsException("Order doesn't exists!");

        if(order.getStatus() != OrderStatus.WAITING_PAYMENT)
            throw new PaymentNotAcceptedException("This order is no longer accepting payments.");

        Payment existingPayment = getPaymentByOrderAdapter.getPaymentByOrder(payment.getOrder());

        if(existingPayment != null && existingPayment.getStatus() != PaymentStatus.FAILED)
            throw new PaymentNotAcceptedException("There is already a payment for this order");

        return createPixPaymentAdapter.create(payment);
    }
}
