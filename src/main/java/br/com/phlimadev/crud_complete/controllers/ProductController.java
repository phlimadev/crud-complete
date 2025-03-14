package br.com.phlimadev.crud_complete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.phlimadev.crud_complete.dtos.in.ProductRequest;
import br.com.phlimadev.crud_complete.dtos.out.ProductResponse;
import br.com.phlimadev.crud_complete.services.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> register(@RequestBody @Valid ProductRequest newProduct) {
        ProductResponse product = service.register(newProduct);
        return new ResponseEntity<ProductResponse>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long id,  @RequestBody ProductRequest productUpdated) {
        ProductResponse product = service.update(id, productUpdated);
        return new ResponseEntity<ProductResponse>(product, HttpStatus.OK);
    }
}
