package com.luizreis.ecommerce.core.domain.exceptions;

public class CustomerAlreadyExistsException extends Exception{

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
