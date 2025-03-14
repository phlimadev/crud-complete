package br.com.phlimadev.crud_complete.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.phlimadev.crud_complete.dtos.out.ExceptionResponse;
import br.com.phlimadev.crud_complete.exceptions.IdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ExceptionResponse> threatIdNotFound(IdNotFoundException exception) {
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(), "NOT_FOUND", "404", exception.getMessage()), HttpStatus.NOT_FOUND);
    }
    
}
