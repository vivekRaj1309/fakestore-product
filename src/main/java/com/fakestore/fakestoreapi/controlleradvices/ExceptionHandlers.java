package com.fakestore.fakestoreapi.controlleradvices;

import com.fakestore.fakestoreapi.dto.ExceptionDto;
import com.fakestore.fakestoreapi.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> productNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto(
                productNotFoundException.getMessage(),
                "Product not found, maybe try searching different product."
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
