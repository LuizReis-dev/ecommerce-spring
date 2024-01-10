package com.luizreis.ecommerce.infrastructure.api.category;

import com.luizreis.ecommerce.core.domain.exceptions.CategoryAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.api.dtos.BaseResponse;
import com.luizreis.ecommerce.infrastructure.api.dtos.CategoryRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public interface CategoryController {

    @PostMapping
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody CategoryRequest request) throws CategoryAlreadyExistsException;
}
