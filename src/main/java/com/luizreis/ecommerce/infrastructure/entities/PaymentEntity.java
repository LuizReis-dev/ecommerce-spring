package com.luizreis.ecommerce.infrastructure.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    @Enumerated(EnumType.STRING)
    @Column(name = "method")
    private PaymentMethodEntity method;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatusEntity status;

    @OneToOne
    @JoinColumn(name = "pix_details_id")
    private PixDetailsEntity pixDetails;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, Instant moment, OrderEntity order, PaymentMethodEntity method, PaymentStatusEntity status) {
        this.id = id;
        this.moment = moment;
        this.order = order;
        this.method = method;
        this.status = status;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public PaymentMethodEntity getMethod() {
        return method;
    }

    public void setMethod(PaymentMethodEntity method) {
        this.method = method;
    }

    public PaymentStatusEntity getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEntity status) {
        this.status = status;
    }

    public PixDetailsEntity getPixDetails() {
        return pixDetails;
    }

    public void setPixDetails(PixDetailsEntity pixDetails) {
        this.pixDetails = pixDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
