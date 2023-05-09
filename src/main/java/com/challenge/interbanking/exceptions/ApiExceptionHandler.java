/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
/**
 *
 * @author Agustin Pueblas
 */
@RestControllerAdvice
@ResponseBody
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleException(Exception ex) {
        StandarizedApiExceptionResponse standarizedApiExceptionResponse = new StandarizedApiExceptionResponse("error generico", "input output error.", "code-0", ex.getMessage());
        return new ResponseEntity<>(standarizedApiExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBusinessException(BusinessException ex) {
        StandarizedApiExceptionResponse standarizedApiExceptionResponse = new StandarizedApiExceptionResponse("validation", "error validation", ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(standarizedApiExceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<StandarizedApiExceptionResponse>> handleArgumentNotValidExceptions(
            MethodArgumentNotValidException ex) {
        List<StandarizedApiExceptionResponse> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            StandarizedApiExceptionResponse e = new StandarizedApiExceptionResponse("validation-argument", "Argumento "+((FieldError) error).getField()+" con error.", "03", error.getDefaultMessage());
            errors.add(e);
        });
        return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleJsonParseException(HttpMessageNotReadableException ex) {
        StandarizedApiExceptionResponse standarizedApiExceptionResponse = new StandarizedApiExceptionResponse("json", "invalid format json.", "04", ex.getMessage());
        return new ResponseEntity<>(standarizedApiExceptionResponse, HttpStatus.CONFLICT);
    }
}
