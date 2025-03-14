package br.com.phlimadev.crud_complete.dtos.out;

import java.math.BigDecimal;

import br.com.phlimadev.crud_complete.model.Product;

public record ProductResponse(Long id, String name, BigDecimal price, String description) {
    public ProductResponse(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
