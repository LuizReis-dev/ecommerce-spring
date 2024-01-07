package com.luizreis.ecommerce.core.domain;

import java.util.Objects;

public class OrderItem {
    private Product product;
    private Order order;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Product product, Order order, Integer quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(product, orderItem.product) && Objects.equals(order, orderItem.order) && Objects.equals(quantity, orderItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order, quantity);
    }
}
