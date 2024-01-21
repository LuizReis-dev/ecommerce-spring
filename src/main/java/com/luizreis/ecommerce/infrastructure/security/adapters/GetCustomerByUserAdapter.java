package com.luizreis.ecommerce.infrastructure.security.adapters;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.UserEntity;

public interface GetCustomerByUserAdapter {

    Customer getByUser(UserEntity user);
}
