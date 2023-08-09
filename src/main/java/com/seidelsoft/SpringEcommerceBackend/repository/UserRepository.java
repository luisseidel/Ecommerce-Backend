package com.seidelsoft.SpringEcommerceBackend.repository;

import com.seidelsoft.SpringEcommerceBackend.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
