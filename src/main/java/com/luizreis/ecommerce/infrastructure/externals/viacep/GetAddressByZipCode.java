package com.luizreis.ecommerce.infrastructure.externals.viacep;

import com.luizreis.ecommerce.adapters.address.GetAddressByZipCodeAdapter;
import com.luizreis.ecommerce.core.domain.Address;
import com.luizreis.ecommerce.infrastructure.externals.viacep.dto.ViaCepResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class GetAddressByZipCode implements GetAddressByZipCodeAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetAddressByZipCode.class);
    @Override
    public Address getByZipCode(String zipCode) {
        try {
            LOGGER.info("Searching address");
            RestTemplate restTemplate = new RestTemplate();

            String url = "https://viacep.com.br/ws/" + zipCode +"/json/";
            ViaCepResponse response = restTemplate
                    .getForObject(url, ViaCepResponse.class);

            if(response == null) return null;

            Address address = new Address();
            address.setState(response.getUf());
            address.setStreet(response.getLogradouro());
            address.setCity(response.getLocalidade());
            address.setZipCode(response.getCep());
            LOGGER.info(response.toString());

            return address;
        }
        catch (HttpClientErrorException e) {
            return null;
        }
    }
}
