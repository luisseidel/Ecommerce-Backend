package com.seidelsoft.SpringEcommerceBackend.controller;

import com.seidelsoft.SpringEcommerceBackend.model.dto.in.ProductDTO;
import com.seidelsoft.SpringEcommerceBackend.model.entity.Product;
import com.seidelsoft.SpringEcommerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductsController implements SecuredController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody ProductDTO dto) {
        return repository.save(new Product(dto.getName(), dto.getPrice()));
    }

    @PutMapping("/{id}")
    public Optional<Product> update(@PathVariable String id, @RequestBody ProductDTO dto) {
        Optional<Product> c = repository.findById(id);

        c.ifPresent( product -> {
            c.get().setName(dto.getName());
            c.get().setPrice(dto.getPrice());
            repository.save(c.get());
        });

        return c;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        repository.delete(new Product(id));
        return ResponseEntity.ok().build();
    }
}
