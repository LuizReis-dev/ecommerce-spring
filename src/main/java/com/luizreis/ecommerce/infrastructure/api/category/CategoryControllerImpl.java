package com.luizreis.ecommerce.infrastructure.api.category;

import com.luizreis.ecommerce.core.domain.exceptions.CategoryAlreadyExistsException;
import com.luizreis.ecommerce.core.usecases.category.CreateCategoryUseCase;
import com.luizreis.ecommerce.infrastructure.api.dtos.BaseResponse;
import com.luizreis.ecommerce.infrastructure.api.dtos.CategoryRequest;
import com.luizreis.ecommerce.infrastructure.mappers.CategoryMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryControllerImpl implements CategoryController{

    private final CreateCategoryUseCase createCategoryUseCase;
    private final CategoryMapper mapper;

    public CategoryControllerImpl(CreateCategoryUseCase createCategoryUseCase, CategoryMapper mapper) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<BaseResponse> create(CategoryRequest request) throws CategoryAlreadyExistsException {
        boolean result = createCategoryUseCase.create(mapper.requestToModel(request));

        int status = result ? 201 : 400;
        String message = result ? "Category created" : "An error occurred saving the entity";

        BaseResponse response = new BaseResponse(status, message);
        return ResponseEntity.status(status).body(response);
    }
}
