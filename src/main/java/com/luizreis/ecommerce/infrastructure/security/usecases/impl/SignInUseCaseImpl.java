package com.luizreis.ecommerce.infrastructure.security.usecases.impl;

import com.luizreis.ecommerce.infrastructure.api.dtos.SignInRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;
import com.luizreis.ecommerce.infrastructure.entities.UserEntity;
import com.luizreis.ecommerce.infrastructure.security.JwtService;
import com.luizreis.ecommerce.infrastructure.security.usecases.SignInUseCase;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SignInUseCaseImpl implements SignInUseCase {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public SignInUseCaseImpl(AuthenticationManager authenticationManager,  JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse signIn(SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        UserEntity user = (UserEntity) authentication.getPrincipal();

        var jwtToken = jwtService.generateToken(user);

        return new TokenResponse(user.getId(), jwtToken);
    }
}
