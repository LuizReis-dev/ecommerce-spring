package com.luizreis.ecommerce.adapters.product;

import com.luizreis.ecommerce.core.domain.Product;

import java.util.List;

public interface GetProductsByCategoryIdAdapter {

    List<Product> getByCategory(Long categoryId);
}
