package com.luizreis.ecommerce.infrastructure.security.usecases.impl;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.core.usecases.customer.CreateCustomerUseCase;
import com.luizreis.ecommerce.infrastructure.api.dtos.SignupRequest;
import com.luizreis.ecommerce.infrastructure.api.dtos.TokenResponse;
import com.luizreis.ecommerce.infrastructure.entities.Role;
import com.luizreis.ecommerce.infrastructure.entities.UserEntity;
import com.luizreis.ecommerce.infrastructure.mappers.CustomerMapper;
import com.luizreis.ecommerce.infrastructure.repositories.user.UserRepository;
import com.luizreis.ecommerce.infrastructure.security.JwtService;
import com.luizreis.ecommerce.infrastructure.security.usecases.CreateUserUseCase;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final UserRepository repository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CreateUserUseCaseImpl(CreateCustomerUseCase createCustomerUseCase, UserRepository repository, CustomerMapper customerMapper, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.repository = repository;
        this.customerMapper = customerMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse create(SignupRequest request) throws CustomerAlreadyExistsException {
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setFullName(request.getFullName());
        customer.setPhoneNumber(request.getPhoneNumber());

        Customer savedCustomer = createCustomerUseCase.create(customer);

        UserEntity userEntity = new UserEntity();
        userEntity.setCustomer(customerMapper.modelToEntity(savedCustomer));
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userEntity.setRole(Role.ROLE_USER);

        UserEntity savedUserEntity = repository.create(userEntity);

        return new TokenResponse(savedUserEntity.getId(), jwtService.generateToken(savedUserEntity));
    }
}
