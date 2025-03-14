package br.com.phlimadev.crud_complete.dtos.in;

import java.math.BigDecimal;

public record ProductRequest(
    String name, 
    BigDecimal price, 
    String description) {   
}
