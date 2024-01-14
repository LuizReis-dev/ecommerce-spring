package com.luizreis.ecommerce.infrastructure.security.usecases;

import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignupRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;

public interface CreateUserUseCase {

    TokenResponse create(SignupRequest request) throws CustomerAlreadyExistsException;
}
