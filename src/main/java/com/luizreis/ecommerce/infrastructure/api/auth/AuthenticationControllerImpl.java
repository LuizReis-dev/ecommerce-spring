package com.luizreis.ecommerce.infrastructure.api.auth;

import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignInRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignupRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;
import com.luizreis.ecommerce.infrastructure.security.usecases.CreateUserUseCase;
import com.luizreis.ecommerce.infrastructure.security.usecases.SignInUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationControllerImpl implements AuthenticationController{

    private final CreateUserUseCase createUserUseCase;
    private final SignInUseCase signInUseCase;

    public AuthenticationControllerImpl(CreateUserUseCase createUserUseCase, SignInUseCase signInUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.signInUseCase = signInUseCase;
    }

    @Override
    public ResponseEntity<TokenResponse> signup(SignupRequest request) throws CustomerAlreadyExistsException {
        return ResponseEntity.status(201).body(createUserUseCase.create(request));
    }

    @Override
    public ResponseEntity<TokenResponse> signIn(SignInRequest request) {
        return ResponseEntity.status(200).body(signInUseCase.signIn(request));
    }
}
