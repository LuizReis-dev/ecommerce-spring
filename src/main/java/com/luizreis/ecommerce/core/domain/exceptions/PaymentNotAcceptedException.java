package com.luizreis.ecommerce.core.domain.exceptions;

public class PaymentNotAcceptedException extends Exception{

    public PaymentNotAcceptedException(String message) {
        super(message);
    }
}
