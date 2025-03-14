package br.com.phlimadev.crud_complete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.phlimadev.crud_complete.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
