package com.luizreis.ecommerce.infrastructure.api.auth;

import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignInRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignupRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public interface AuthenticationController {

    @PostMapping(value = "/signup")
    public ResponseEntity<TokenResponse> signup(@Valid @RequestBody SignupRequest request) throws CustomerAlreadyExistsException;

    @PostMapping(value = "/signin")
    public ResponseEntity<TokenResponse> signIn(@Valid @RequestBody SignInRequest request);
}
