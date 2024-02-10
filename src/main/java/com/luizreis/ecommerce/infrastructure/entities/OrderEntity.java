package com.luizreis.ecommerce.infrastructure.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<PaymentEntity> payments = new ArrayList<>();

    public OrderEntity() {
    }

    public OrderEntity(Long id, Instant moment, CustomerEntity customer, OrderStatus status, List<OrderItemEntity> items) {
        this.id = id;
        this.moment = moment;
        this.customer = customer;
        this.status = status;
        this.items = items;
    }

    public OrderEntity(Instant moment, CustomerEntity customer, OrderStatus status, List<OrderItemEntity> items) {
        this.moment = moment;
        this.customer = customer;
        this.status = status;
        this.items = items;
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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public List<PaymentEntity> getPayments() {
        return payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
