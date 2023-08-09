package com.seidelsoft.SpringEcommerceBackend.repository;

import com.seidelsoft.SpringEcommerceBackend.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long> {
	Optional<Product> findById(String id);
}
