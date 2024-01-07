package com.luizreis.ecommerce.core.domain;

import java.time.Instant;
import java.util.Objects;

public class Payment {

    private Long id;
    private Instant moment;
    private Order order;
    private PaymentMethod method;
    private PaymentStatus status;

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order order, PaymentMethod method, PaymentStatus status) {
        this.id = id;
        this.moment = moment;
        this.order = order;
        this.method = method;
        this.status = status;
    }

    public Payment(Order order, PaymentMethod method, PaymentStatus status) {
        this.order = order;
        this.method = method;
        this.status = status;
        this.moment = Instant.now();
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
