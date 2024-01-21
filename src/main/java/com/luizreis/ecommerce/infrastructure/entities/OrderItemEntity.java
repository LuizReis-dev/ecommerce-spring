package com.luizreis.ecommerce.infrastructure.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    private Integer quantity;
    private Double total;

    public OrderItemEntity() {
    }

    public OrderItemEntity(Long id, ProductEntity product, OrderEntity order, Integer quantity, Double total) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderItemEntity(ProductEntity product, OrderEntity order, Integer quantity, Double total) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderItemEntity(ProductEntity product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
