package com.luizreis.ecommerce.core.domain.exceptions;

public class CategoryAlreadyExistsException extends Exception{
    public CategoryAlreadyExistsException(String message){
        super(message);
    }
}
