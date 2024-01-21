package com.luizreis.ecommerce.infrastructure.api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemRequest {

    private Long id;

    @NotNull
    private Long productId;
    @NotNull
    @Min(value= 1)
    private Integer quantity;

    public OrderItemRequest(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
