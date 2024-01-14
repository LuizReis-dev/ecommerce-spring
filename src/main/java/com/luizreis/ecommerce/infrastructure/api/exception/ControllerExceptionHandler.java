package com.luizreis.ecommerce.infrastructure.api.exception;

import com.luizreis.ecommerce.core.domain.exceptions.CategoryAlreadyExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PriceMustBePositiveException;
import com.luizreis.ecommerce.infrastructure.api.dtos.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(CategoryAlreadyExistsException.class)
    ResponseEntity<BaseResponse> categoryAlreadyExists(CategoryAlreadyExistsException e){
        BaseResponse response = new BaseResponse(400, e.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(CategoryDoesntExistsException.class)
    ResponseEntity<BaseResponse> categoryDoesntExists(CategoryDoesntExistsException e){
        BaseResponse response = new BaseResponse(404, e.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    ResponseEntity<BaseResponse> customerAlreadyExists(CustomerAlreadyExistsException e){
        BaseResponse response = new BaseResponse(400, e.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(PriceMustBePositiveException.class)
    ResponseEntity<BaseResponse> priceMustBePositive(PriceMustBePositiveException e){
        BaseResponse response = new BaseResponse(400, e.getMessage());
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
