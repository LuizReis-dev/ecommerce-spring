package com.luizreis.ecommerce.infrastructure.api.dtos;

import jakarta.validation.constraints.NotBlank;

public class ProductRequest {

    @NotBlank(message = "Field required")
    private String name;
    @NotBlank(message = "Field required")
    private String description;
    private Double price;
    private Long categoryId;


    public ProductRequest(String name, String description, Double price, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
