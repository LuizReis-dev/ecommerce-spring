package com.luizreis.ecommerce.core.usecases.product;

import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PriceMustBePositiveException;

public interface CreateProductUseCase {
    boolean create(Product product) throws CategoryDoesntExistsException, PriceMustBePositiveException;
}
