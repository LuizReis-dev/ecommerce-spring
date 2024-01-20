package com.luizreis.ecommerce.application.usecases.product;

import com.luizreis.ecommerce.adapters.product.GetProductsByCategoryIdAdapter;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.usecases.product.GetProductsByCategoryIdUseCase;

import java.util.List;

public class GetProductsByCategoryIdUseCaseImpl implements GetProductsByCategoryIdUseCase {

    private final GetProductsByCategoryIdAdapter getProductByCategoryIdAdapter;

    public GetProductsByCategoryIdUseCaseImpl(GetProductsByCategoryIdAdapter getProductByCategoryIdAdapter) {
        this.getProductByCategoryIdAdapter = getProductByCategoryIdAdapter;
    }

    @Override
    public List<Product> getByCategory(Long categoryId) {
        return getProductByCategoryIdAdapter.getByCategory(categoryId);
    }
}
