package com.luizreis.ecommerce.core.domain.exceptions;

public class OrderDoesntExistsException extends Exception{

    public OrderDoesntExistsException(String message) {
        super(message);
    }
}
