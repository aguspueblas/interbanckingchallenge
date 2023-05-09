/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.challenge.interbanking.controllers;

import com.challenge.interbanking.dtos.CompanyDto;
import com.challenge.interbanking.dtos.CreateCompanyDto;
import com.challenge.interbanking.entities.Company;
import com.challenge.interbanking.exceptions.BusinessException;
import com.challenge.interbanking.services.CompanyService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Agustin Pueblas
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping()
    public ResponseEntity<List<CompanyDto>> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/transferlastmonth")
    public ResponseEntity<List<CompanyDto>> getCompaniesTransferLastMonth() {
        return companyService.findByTransferLastMonth();
    }

    @GetMapping("/addlastmonth")
    public ResponseEntity<List<CompanyDto>> getCompaniesAddLastMonth() {
        return companyService.findByAddCompaniesLastMont();
    }

    @PostMapping
    public ResponseEntity<CompanyDto> post(@Valid @RequestBody CreateCompanyDto input) {

        return companyService.create(input);
    }
}
