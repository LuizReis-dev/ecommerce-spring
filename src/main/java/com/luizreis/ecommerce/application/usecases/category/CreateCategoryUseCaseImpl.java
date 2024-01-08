package com.luizreis.ecommerce.application.usecases.category;

import com.luizreis.ecommerce.adapters.category.CategoryExistsByNameAdapter;
import com.luizreis.ecommerce.adapters.category.CreateCategoryAdapter;
import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryAlreadyExistsException;
import com.luizreis.ecommerce.core.usecases.category.CreateCategoryUseCase;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private final CategoryExistsByNameAdapter categoryExistsByNameAdapter;
    private final CreateCategoryAdapter createCategoryAdapter;

    public CreateCategoryUseCaseImpl(CategoryExistsByNameAdapter categoryExistsByNameAdapter, CreateCategoryAdapter createCategoryAdapter) {
        this.categoryExistsByNameAdapter = categoryExistsByNameAdapter;
        this.createCategoryAdapter = createCategoryAdapter;
    }

    @Override
    public void create(Category category) throws CategoryAlreadyExistsException {
        if(categoryExistsByNameAdapter.existsByName(category.getName())) throw new CategoryAlreadyExistsException("Category already exists");

        createCategoryAdapter.create(category);
    }
}
