package br.com.phlimadev.crud_complete.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phlimadev.crud_complete.dtos.in.ProductRequest;
import br.com.phlimadev.crud_complete.dtos.out.ProductResponse;
import br.com.phlimadev.crud_complete.exceptions.IdNotFoundException;
import br.com.phlimadev.crud_complete.model.Product;
import br.com.phlimadev.crud_complete.repositories.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<ProductResponse> findAll() {
        List<ProductResponse> allProducts = repository.findAll().stream().map(ProductResponse::new).toList();
        return allProducts;
    }

    @Transactional
    public ProductResponse register(ProductRequest product) {
        Product newProduct = new Product(product);
        repository.save(newProduct);
        return new ProductResponse(newProduct);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IdNotFoundException("Id " + id + " not found.");
        }
        repository.deleteById(id);
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest productUpdated) {
        Product product = repository.findById(id).orElseThrow(() -> new IdNotFoundException("Id " + id + " not found."));
        if (productUpdated.name() != null) {
            product.setName(productUpdated.name());
        }
        if (productUpdated.price() != null) {
            product.setPrice(productUpdated.price());
        } 
        if (productUpdated.description() != null) {
            product.setDescription(productUpdated.description());
        }

        return new ProductResponse(product);
    }
}