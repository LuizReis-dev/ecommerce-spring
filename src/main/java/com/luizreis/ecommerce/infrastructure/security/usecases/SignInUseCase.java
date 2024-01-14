package com.luizreis.ecommerce.infrastructure.security.usecases;

import com.luizreis.ecommerce.infrastructure.api.dtos.SignInRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;

public interface SignInUseCase {

    TokenResponse signIn(SignInRequest request);
}
