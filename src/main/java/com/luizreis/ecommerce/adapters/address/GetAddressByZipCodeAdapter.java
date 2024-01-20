package com.luizreis.ecommerce.adapters.address;

import com.luizreis.ecommerce.core.domain.Address;

public interface GetAddressByZipCodeAdapter {

    Address getByZipCode(String zipCode);
}
