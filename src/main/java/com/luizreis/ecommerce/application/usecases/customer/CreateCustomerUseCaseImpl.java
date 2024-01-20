package com.luizreis.ecommerce.application.usecases.customer;

import com.luizreis.ecommerce.adapters.address.GetAddressByZipCodeAdapter;
import com.luizreis.ecommerce.adapters.customer.CreateCustomerAdapter;
import com.luizreis.ecommerce.adapters.customer.CustomerExistsByEmailAdapter;
import com.luizreis.ecommerce.core.domain.Address;
import com.luizreis.ecommerce.core.domain.Customer;
import com.luizreis.ecommerce.core.domain.exceptions.AddressNotFoundException;
import com.luizreis.ecommerce.core.domain.exceptions.CustomerAlreadyExistsException;
import com.luizreis.ecommerce.core.usecases.customer.CreateCustomerUseCase;

public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CreateCustomerAdapter createCustomerAdapter;
    private final CustomerExistsByEmailAdapter customerExistsByEmailAdapter;
    private final GetAddressByZipCodeAdapter getAddressByZipCodeAdapter;

    public CreateCustomerUseCaseImpl(CreateCustomerAdapter createCustomerAdapter, CustomerExistsByEmailAdapter customerExistsByEmailAdapter, GetAddressByZipCodeAdapter getAddressByZipCodeAdapter) {
        this.createCustomerAdapter = createCustomerAdapter;
        this.customerExistsByEmailAdapter = customerExistsByEmailAdapter;
        this.getAddressByZipCodeAdapter = getAddressByZipCodeAdapter;
    }

    @Override
    public Customer create(Customer customer) throws CustomerAlreadyExistsException, AddressNotFoundException {

        if(customerExistsByEmailAdapter.existsByEmail(customer.getEmail()))
            throw new CustomerAlreadyExistsException("Customer already exists!");

        Address newAddress = getAddressByZipCodeAdapter.getByZipCode(customer.getAddress().getZipCode());

        if(newAddress == null)
            throw new AddressNotFoundException("Address not found for the ZipCode: " + customer.getAddress().getZipCode());

        customer.getAddress().setZipCode(newAddress.getZipCode());
        customer.getAddress().setCity(newAddress.getCity());
        customer.getAddress().setStreet(newAddress.getStreet());
        customer.getAddress().setState(newAddress.getState());
        customer.getAddress().setCountry("Brasil");

        return createCustomerAdapter.create(customer);
    }
}
