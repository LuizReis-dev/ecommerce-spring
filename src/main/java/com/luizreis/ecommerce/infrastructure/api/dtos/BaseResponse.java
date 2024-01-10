package com.luizreis.ecommerce.infrastructure.api.dtos;

public class BaseResponse {
    private Integer status;
    private String message;

    public BaseResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
