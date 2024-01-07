package com.luizreis.ecommerce.core.domain;

import java.time.Instant;
import java.util.Objects;

public class Avaliation {

    private Long id;
    private Customer customer;
    private Product product;
    private Integer rating;
    private String comment;
    private Instant createdAt;
    private Instant deletedAt;

    public Avaliation() {
    }

    public Avaliation(Long id, Customer customer, Product product, Integer rating, String comment, Instant createdAt, Instant deletedAt) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Avaliation(Customer customer, Product product, Integer rating, String comment) {
        this.customer = customer;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliation that = (Avaliation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
