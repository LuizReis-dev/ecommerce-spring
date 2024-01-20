package com.luizreis.ecommerce.core.domain.exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message) {
        super(message);
    }
}
