package com.luizreis.ecommerce.application.usecases.product;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByIdAdapter;
import com.luizreis.ecommerce.adapters.product.CreateProductAdapter;
import com.luizreis.ecommerce.core.domain.Product;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryDoesntExistsException;
import com.luizreis.ecommerce.core.domain.exceptions.PriceMustBePositiveException;
import com.luizreis.ecommerce.core.usecases.product.CreateProductUseCase;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final CategoryExistsByIdAdapter categoryExistsByIdAdapter;
    private final CreateProductAdapter createProductAdapter;

    public CreateProductUseCaseImpl(CategoryExistsByIdAdapter categoryExistsByIdAdapter, CreateProductAdapter createProductAdapter) {
        this.categoryExistsByIdAdapter = categoryExistsByIdAdapter;
        this.createProductAdapter = createProductAdapter;
    }

    @Override
    public boolean create(Product product) throws CategoryDoesntExistsException, PriceMustBePositiveException {

        if(!categoryExistsByIdAdapter.existsById(product.getCategory().getId()))
            throw new CategoryDoesntExistsException("Category doesn't exists");

        if(product.getPrice() <= 0)
            throw new PriceMustBePositiveException("Price must be positive");

        return createProductAdapter.create(product);
    }
}
