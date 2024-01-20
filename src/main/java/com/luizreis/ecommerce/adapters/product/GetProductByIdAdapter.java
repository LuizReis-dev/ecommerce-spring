package com.luizreis.ecommerce.adapters.product;

import com.luizreis.ecommerce.core.domain.Product;

public interface GetProductByIdAdapter {

    Product getById(Long id);
}
