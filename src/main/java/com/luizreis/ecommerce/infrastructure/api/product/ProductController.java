package com.luizreis.ecommerce.infrastructure.api.product;

import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PriceMustBePositiveException;
import com.luizreis.ecommerce.infrastructure.api.dtos.BaseResponse;
import com.luizreis.ecommerce.infrastructure.api.dtos.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public interface ProductController {

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody ProductRequest request) throws CategoryDoesntExistsException, PriceMustBePositiveException;

    @GetMapping
    public ResponseEntity<List<Product>> getAll();

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<Product>> getAllByCategoryID(@PathVariable Long categoryId);
}
