package com.springbootpgrest.talley;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Long> {
    //Optional<User> findByUsername(String username);
    //boolean existsByUsername(String username);
}
