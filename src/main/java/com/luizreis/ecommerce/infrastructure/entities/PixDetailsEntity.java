package com.luizreis.ecommerce.infrastructure.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pix_details")
public class PixDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String qrCode;
    @Column(columnDefinition="TEXT")
    private String qrCodeBase64;
    @OneToOne(mappedBy = "pixDetails")
    private PaymentEntity payment;
    private Instant createdAt;
    private Instant dateOfExpiration;

    public PixDetailsEntity() {
    }

    public PixDetailsEntity(Long id, Double amount, String qrCode, String qrCodeBase64, Instant createdAt, Instant dateOfExpiration) {
        this.id = id;
        this.amount = amount;
        this.qrCode = qrCode;
        this.qrCodeBase64 = qrCodeBase64;
        this.createdAt = createdAt;
        this.dateOfExpiration = dateOfExpiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Instant dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PixDetailsEntity that = (PixDetailsEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
