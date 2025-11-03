package com.springbootpgrest.talley;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductsController {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // GET /api/products
    @GetMapping
    public List<Products> getAllProducts() {
        var products = new ArrayList<Products>();
        productsRepository.findAll().forEach(products::add);
        return products;
    }

    // GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Optional<Products> productOpt = productsRepository.findById(id);
        return productOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Products> createProduct(@Valid @RequestBody Products product) {
        Products saved = productsRepository.save(product);

        // Build URI to the newly created resource: /api/products/{id}
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id,
                                                 @Valid @RequestBody Products productRequest) {
        return productsRepository.findById(id)
                .map(existing -> {
                    existing.setName(productRequest.getName());
                    existing.setPrice(productRequest.getPrice());
                    existing.setCreated_at(productRequest.getCreated_at());
                    existing.setDeleted_at(productRequest.getDeleted_at());
                    existing.setUpdated_at(Date.from(Instant.now()));

                    Products updated = productsRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    return ResponseEntity.notFound().build();
                });
    }

    // DELETE /api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productsRepository.findById(id)
                .map(existing -> {
                    productsRepository.deleteById(id);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}