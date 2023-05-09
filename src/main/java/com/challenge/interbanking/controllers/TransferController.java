/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.challenge.interbanking.controllers;

import com.challenge.interbanking.dtos.CreateTransferDto;
import com.challenge.interbanking.dtos.TransferDto;
import com.challenge.interbanking.exceptions.BusinessException;
import com.challenge.interbanking.services.TransferService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Agustin Pueblas
 */
@RestController
@RequestMapping("/transfer")
public class TransferController {
    
    @Autowired
    TransferService service;
    
    @PostMapping()
    public ResponseEntity<TransferDto> create(@Valid @RequestBody CreateTransferDto dto) throws BusinessException{
        return service.create(dto);
    }
    
}
