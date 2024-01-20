package com.luizreis.ecommerce.application.usecases.product;

import com.luizreis.ecommerce.adapters.product.GetAllProductsAdapter;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.usecases.product.GetAllProductsUseCase;

import java.util.List;

public class GetAllProductUseCaseImpl implements GetAllProductsUseCase {

        private final GetAllProductsAdapter getAllProductsAdapter;

    public GetAllProductUseCaseImpl(GetAllProductsAdapter getAllProductsAdapter) {
        this.getAllProductsAdapter = getAllProductsAdapter;
    }

    @Override
    public List<Product> getAll() {
        return getAllProductsAdapter.getAll();
    }
}
