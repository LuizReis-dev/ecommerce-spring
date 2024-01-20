package com.luizreis.ecommerce.infrastructure.mappers;

import com.luizreis.ecommerce.core.domain.Address;
import com.luizreis.ecommerce.infrastructure.entities.AddressEntity;

public interface AddressMapper {

    AddressEntity modelToEntity(Address address);
}
