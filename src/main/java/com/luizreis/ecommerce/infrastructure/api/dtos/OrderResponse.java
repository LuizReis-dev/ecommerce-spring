package com.luizreis.ecommerce.infrastructure.api.dtos;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class OrderResponse {

    private Long id;
    private List<OrderItemResponse> items;
    private UUID customerId;
    private Double total;
    private Instant moment;

    public OrderResponse(Long id, List<OrderItemResponse> items, UUID customerId, Double total, Instant moment) {
        this.id = id;
        this.items = items;
        this.customerId = customerId;
        this.total = total;
        this.moment = moment;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public Double getTotal() {
        return total;
    }

    public Instant getMoment() {
        return moment;
    }
}
