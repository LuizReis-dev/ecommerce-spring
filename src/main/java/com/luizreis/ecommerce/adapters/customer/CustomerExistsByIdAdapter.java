package com.luizreis.ecommerce.adapters.customer;

import java.util.UUID;

public interface CustomerExistsByIdAdapter {

    boolean existsById(UUID id);
}
