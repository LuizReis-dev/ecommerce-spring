package com.luizreis.ecommerce.core.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id;
    private Instant moment;
    private Customer customer;
    private OrderStatus status;
    private List<OrderItem> orderItems = new ArrayList<>();
    public Order() {
    }

    public Order(Long id, Instant moment, Customer customer, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.customer = customer;
        this.status = status;
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.moment = Instant.now();
        this.status = OrderStatus.WAITING_PAYMENT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotal(){
        return getOrderItems().stream()
                .mapToDouble(OrderItem::getTotal)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
