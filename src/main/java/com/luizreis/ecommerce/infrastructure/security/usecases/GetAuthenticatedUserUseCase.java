package com.luizreis.ecommerce.infrastructure.security.usecases;

import com.luizreis.ecommerce.core.domain.Customer;

public interface GetAuthenticatedUserUseCase {

    Customer getAuthenticatedUser();
}
