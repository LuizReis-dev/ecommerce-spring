package com.luizreis.ecommerce.core.domain;

import java.time.Instant;
import java.util.Objects;

public class PixDetails {

    private Long id;
    private Double amount;
    private String qrCode;
    private String qrCodeBase64;
    private Instant createdAt;
    private Instant dateOfExpiration;

    public PixDetails(Long id, Double amount, String qrCode, String qrCodeBase64, Instant createdAt, Instant dateOfExpiration) {
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

    public String getQrCode() {
        return qrCode;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getDateOfExpiration() {
        return dateOfExpiration;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PixDetails that = (PixDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
