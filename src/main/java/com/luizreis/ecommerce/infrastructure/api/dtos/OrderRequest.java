package com.luizreis.ecommerce.infrastructure.api.dtos;


import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class OrderRequest {

    @NotNull
    private List<OrderItemRequest> items;

    public OrderRequest() {
    }

    public OrderRequest(List<OrderItemRequest> items) {
        this.items = items;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

}
