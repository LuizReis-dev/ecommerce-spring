package com.luizreis.ecommerce.core.domain.exceptions;

public class PriceMustBePositiveException extends Exception{

    public PriceMustBePositiveException(String message) {
        super(message);
    }
}
