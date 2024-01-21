package com.luizreis.ecommerce.infrastructure.security.usecases.impl;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.infrastructure.entities.UserEntity;
import com.luizreis.ecommerce.infrastructure.security.adapters.GetCustomerByUserAdapter;
import com.luizreis.ecommerce.infrastructure.security.usecases.GetAuthenticatedUserUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetAuthenticatedUserUseCaseImpl implements GetAuthenticatedUserUseCase {

    private final GetCustomerByUserAdapter getCustomerByUserAdapter;

    public GetAuthenticatedUserUseCaseImpl(GetCustomerByUserAdapter getCustomerByUserAdapter) {
        this.getCustomerByUserAdapter = getCustomerByUserAdapter;
    }

    @Override
    public Customer getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        UserEntity user = new UserEntity();
        user.setEmail(userName);

        return getCustomerByUserAdapter.getByUser(user);
    }
}
