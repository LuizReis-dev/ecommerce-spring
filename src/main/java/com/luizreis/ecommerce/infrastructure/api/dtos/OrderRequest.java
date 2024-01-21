package com.luizreis.ecommerce.infrastructure.api.dtos;


import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class OrderRequest {

    @NotNull
    private List<OrderItemRequest> items;
    @NotNull
    private UUID customerId;


    public OrderRequest(List<OrderItemRequest> items, UUID customerId) {
        this.items = items;
        this.customerId = customerId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
