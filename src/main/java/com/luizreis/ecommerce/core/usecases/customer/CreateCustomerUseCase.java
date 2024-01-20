package com.luizreis.ecommerce.core.usecases.customer;

import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.exceptions.AddressNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;

public interface CreateCustomerUseCase {

    Customer create(Customer customer) throws CustomerAlreadyExistsException, AddressNotFoundException;
}
