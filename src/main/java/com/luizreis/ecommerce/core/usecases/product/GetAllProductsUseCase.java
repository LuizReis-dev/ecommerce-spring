package com.luizreis.ecommerce.core.usecases.product;

import com.luizreis.ecommerce.core.domain.Product;

import java.util.List;

public interface GetAllProductsUseCase {

    List<Product> getAll();
}
