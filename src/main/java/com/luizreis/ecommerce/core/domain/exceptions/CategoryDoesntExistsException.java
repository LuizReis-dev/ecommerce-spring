package com.luizreis.ecommerce.core.domain.exceptions;

public class CategoryDoesntExistsException extends Exception{

    public CategoryDoesntExistsException(String message) {
        super(message);
    }
}
