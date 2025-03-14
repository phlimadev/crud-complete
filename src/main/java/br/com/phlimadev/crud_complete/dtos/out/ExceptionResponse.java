package br.com.phlimadev.crud_complete.dtos.out;

import java.time.LocalDateTime;

public record ExceptionResponse(LocalDateTime timestamp, String error, String status, String message) {
    
}