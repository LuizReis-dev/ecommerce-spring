package com.luizreis.ecommerce.application.usecases.payment;

import com.luizreis.ecommerce.adapters.order.GetOrderByIdAdapter;
import com.luizreis.ecommerce.adapters.payment.CreatePixPaymentAdapter;
import com.luizreis.ecommerce.adapters.payment.GetLastPaymentByOrderAdapter;
import com.luizreis.ecommerce.core.domain.*;
import com.luizreis.ecommerce.core.domain.exceptions.OrderDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PaymentNotAcceptedException;
import com.luizreis.ecommerce.core.usecases.payment.CreatePixPaymentUseCase;

public class CreatePixPaymentUseCaseImpl implements CreatePixPaymentUseCase {

    private final CreatePixPaymentAdapter createPixPaymentAdapter;
    private final GetLastPaymentByOrderAdapter getLastPaymentByOrderAdapter;
    private final GetOrderByIdAdapter getOrderByIdAdapter;

    public CreatePixPaymentUseCaseImpl(CreatePixPaymentAdapter createPixPaymentAdapter, GetLastPaymentByOrderAdapter getLastPaymentByOrderAdapter, GetOrderByIdAdapter getOrderByIdAdapter) {
        this.createPixPaymentAdapter = createPixPaymentAdapter;
        this.getLastPaymentByOrderAdapter = getLastPaymentByOrderAdapter;
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

        Payment lastPayment = getLastPaymentByOrderAdapter.getLastPaymentByOrder(payment.getOrder());

        if(lastPayment != null && lastPayment.getStatus() != PaymentStatus.FAILED)
            throw new PaymentNotAcceptedException("There is already a payment for this order");

        payment.setStatus(PaymentStatus.IN_PROGRESS);
        return createPixPaymentAdapter.create(payment);

    }
}
