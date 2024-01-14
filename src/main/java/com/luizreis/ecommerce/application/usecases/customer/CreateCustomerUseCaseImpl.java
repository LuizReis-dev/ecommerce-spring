package com.luizreis.ecommerce.application.usecases.customer;

import com.luizreis.ecommerce.adapters.customer.CreateCustomerAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByEmailAdapter;
import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.core.usecases.customer.CreateCustomerUseCase;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CreateCustomerAdapter createCustomerAdapter;
    private final CustomerExistsByEmailAdapter customerExistsByEmailAdapter;

    public CreateCustomerUseCaseImpl(CreateCustomerAdapter createCustomerAdapter, CustomerExistsByEmailAdapter customerExistsByEmailAdapter) {
        this.createCustomerAdapter = createCustomerAdapter;
        this.customerExistsByEmailAdapter = customerExistsByEmailAdapter;
    }

    @Override
    public boolean create(Customer customer) throws CustomerAlreadyExistsException {
        if(customerExistsByEmailAdapter.existsByEmail(customer.getEmail()))
            throw new CustomerAlreadyExistsException("Customer already exists!");

        return createCustomerAdapter.create(customer);
    }
}
