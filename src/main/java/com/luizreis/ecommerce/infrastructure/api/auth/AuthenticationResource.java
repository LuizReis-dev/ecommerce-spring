package com.luizreis.ecommerce.infrastructure.api.auth;

import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignupRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;
import com.luizreis.ecommerce.infrastructure.security.usecases.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationResource implements AuthenticationController{

    private final CreateUserUseCase createUserUseCase;

    public AuthenticationResource(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public ResponseEntity<TokenResponse> signup(SignupRequest request) throws CustomerAlreadyExistsException {
        return ResponseEntity.status(201).body(createUserUseCase.create(request));
    }
}
