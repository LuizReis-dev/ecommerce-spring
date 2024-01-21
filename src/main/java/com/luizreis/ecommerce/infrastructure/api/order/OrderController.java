package com.luizreis.ecommerce.infrastructure.api.order;

import com.luizreis.ecommerce.core.domain.exceptions.CustomerNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.ProductNotFoundException;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public interface OrderController {


    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody OrderRequest request) throws CustomerNotFoundException, ProductNotFoundException;
}
