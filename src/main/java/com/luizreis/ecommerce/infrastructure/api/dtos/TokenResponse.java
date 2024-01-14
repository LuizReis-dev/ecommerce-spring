package com.luizreis.ecommerce.infrastructure.api.dtos;

public class TokenResponse {

    private Long id;
    private String token;

    public TokenResponse(Long id, String token) {
        this.id = id;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
