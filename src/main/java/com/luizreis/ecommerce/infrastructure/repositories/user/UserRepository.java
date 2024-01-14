package com.luizreis.ecommerce.infrastructure.repositories.user;

import com.luizreis.ecommerce.infrastructure.entities.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long id);
}
