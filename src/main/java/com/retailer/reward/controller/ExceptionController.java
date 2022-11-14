package com.retailer.reward.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.retailer.reward.records.response.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {
            HttpMessageNotReadableException.class,
            JsonParseException.class,
            ValidationException.class,
            IllegalStateException.class,
            DataIntegrityViolationException.class,
            NoSuchElementException.class
    })
    public ResponseEntity<ExceptionResponse> processException(Exception ex){
        return new ResponseEntity<>(new ExceptionResponse(HttpStatus.FAILED_DEPENDENCY,ex.getMessage()),HttpStatus.FAILED_DEPENDENCY);
    }

}
