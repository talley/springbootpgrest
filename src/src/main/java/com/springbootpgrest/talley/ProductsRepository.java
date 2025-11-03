package com.springbootpgrest.talley;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Long> {
}
