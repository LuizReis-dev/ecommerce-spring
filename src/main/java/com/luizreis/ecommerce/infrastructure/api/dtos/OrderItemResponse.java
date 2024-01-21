package com.luizreis.ecommerce.infrastructure.api.dtos;

public class OrderItemResponse {

    private Long productId;
    private Integer quantity;
    private Double total;

    public OrderItemResponse( Long productId, Integer quantity, Double total) {
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
    }


    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotal() {
        return total;
    }
}
