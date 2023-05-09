/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Agustin Pueblas
 */
@Data
public class BusinessException extends Exception{
    private Long id;
    private String code;
    private HttpStatus status;
    
    public BusinessException(Long id, String code, String message, HttpStatus status){
        super(message);
        this.id = id;
        this.code = code;
        this.status = status;
    }
}
