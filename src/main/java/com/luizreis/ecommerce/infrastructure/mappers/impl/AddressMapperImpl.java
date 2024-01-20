package com.luizreis.ecommerce.infrastructure.mappers.impl;

import com.luizreis.ecommerce.core.domain.Address;
import com.luizreis.ecommerce.infrastructure.entities.AddressEntity;
import com.luizreis.ecommerce.infrastructure.mappers.AddressMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {


    @Override
    public AddressEntity modelToEntity(Address address) {

        AddressEntity entity = new AddressEntity();
        entity.setCity(address.getCity());
        entity.setComplement(address.getComplement());
        entity.setCountry(address.getCountry());
        entity.setState(address.getState());
        entity.setNumber(address.getNumber());
        entity.setId(address.getId());
        entity.setZipCode(address.getZipCode());
        entity.setStreet(address.getStreet());
        entity.setComplement(entity.getComplement());

        return entity;
    }
}
