package com.luizreis.ecommerce.core.usecases.category;

import com.luizreis.ecommerce.core.domain.Category;
import com.luizreis.ecommerce.core.domain.exceptions.CategoryAlreadyExistsException;

public interface CreateCategoryUseCase {

    boolean create(Category category) throws CategoryAlreadyExistsException;
}
