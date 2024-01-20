package com.luizreis.ecommerce.infrastructure.api.product;

import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PriceMustBePositiveException;
import com.luizreis.ecommerce.core.usecases.product.CreateProductUseCase;
import com.luizreis.ecommerce.core.usecases.product.GetAllProductsUseCase;
import com.luizreis.ecommerce.core.usecases.product.GetProductsByCategoryIdUseCase;
import com.luizreis.ecommerce.infrastructure.api.dtos.BaseResponse;
import com.luizreis.ecommerce.infrastructure.api.dtos.ProductRequest;
import com.luizreis.ecommerce.infrastructure.mappers.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductControllerImpl implements ProductController{

    private final CreateProductUseCase createProductUseCase;
    private final GetAllProductsUseCase getAllProductsUseCase;
    private final GetProductsByCategoryIdUseCase getProductsByCategoryIdUseCase;
    private final ProductMapper mapper;

    public ProductControllerImpl(CreateProductUseCase createProductUseCase, GetAllProductsUseCase getAllProductsUseCase, GetProductsByCategoryIdUseCase getProductsByCategoryIdUseCase, ProductMapper mapper) {
        this.createProductUseCase = createProductUseCase;
        this.getAllProductsUseCase = getAllProductsUseCase;
        this.getProductsByCategoryIdUseCase = getProductsByCategoryIdUseCase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<BaseResponse> create(ProductRequest request) throws CategoryDoesntExistsException, PriceMustBePositiveException {
        boolean result = createProductUseCase.create(mapper.requestToModel(request));

        int status = result ? 201 : 400;
        String message = result ? "Product created" : "An error occurred saving the entity";

        BaseResponse response = new BaseResponse(status, message);
        return ResponseEntity.status(status).body(response);
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(getAllProductsUseCase.getAll());
    }

    @Override
    public ResponseEntity<List<Product>> getAllByCategoryID(Long categoryId) {
        return ResponseEntity.ok(getProductsByCategoryIdUseCase.getByCategory(categoryId));
    }
}
