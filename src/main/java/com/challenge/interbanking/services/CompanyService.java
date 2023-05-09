/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.challenge.interbanking.services;

import com.challenge.interbanking.dtos.CompanyDto;
import com.challenge.interbanking.dtos.CreateCompanyDto;
import com.challenge.interbanking.entities.Company;
import com.challenge.interbanking.entities.Transfer;
import com.challenge.interbanking.repositorys.CompanyRepository;
import com.challenge.interbanking.repositorys.TransferRepository;
import com.challenge.interbanking.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.*;
import java.time.*;
import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Agustin Pueblas
 */
@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepo;
    @Autowired
    TransferRepository transferRepo;

    public ResponseEntity<List<CompanyDto>> findAll() {
        List<CompanyDto> companies = companyRepo.findAll().stream().map(c -> CompanyDto.fromEntity(c, true)).collect(Collectors.toList());
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    public ResponseEntity<List<CompanyDto>> findByTransferLastMonth() {
        List<CompanyDto> companies = transferRepo.findCompaniesWithTransfersLastMonth(Utils.getLastMonth()).stream().map(c -> CompanyDto.fromEntity(c, true)).collect(Collectors.toList());
        
        return companies.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }

    public ResponseEntity<List<CompanyDto>> findByAddCompaniesLastMont() {
        List<CompanyDto> companies = companyRepo.findCompaniesAddLastMonth(Utils.getLastMonth()).stream().map(c-> CompanyDto.fromEntity(c, false)).collect(Collectors.toList());
        return companies.isEmpty()? ResponseEntity.noContent().build() : ResponseEntity.ok(companies);
    }
    
    public ResponseEntity<CompanyDto> create(@Valid CreateCompanyDto company) {
        //Simple metodo para cargar Companias
        Company result = companyRepo.save(Company.fromCreateCompanyDto(company));
        
        return new ResponseEntity<>(CompanyDto.fromEntity(result, Boolean.FALSE),HttpStatus.CREATED);
        
    }

//    @PostConstruct
//    public void loadData() {
//        // Aquí cargas los datos en la base de datos H2 utilizando el repositori
//        companyRepo.save(new Company(1L, 1, "COMPANY1", LocalDateTime.of(2023, 5, 8, 10, 0), null));
//        companyRepo.save(new Company(2L, 3, "COMPANY2", LocalDateTime.of(2023, 2, 8, 10, 0), null));
//        companyRepo.save(new Company(3L, 3, "COMPANY3", LocalDateTime.of(2023, 5, 8, 10, 0), null));
//
//        transferRepo.save(new Transfer(4L, 20, 98327, 19823, LocalDateTime.of(2023, 5, 8, 10, 0), new Company(1L)));
//        transferRepo.save(new Transfer(5L, 20, 98327, 19823, LocalDateTime.of(2023, 2, 9, 10, 0), new Company(1L)));
//        transferRepo.save(new Transfer(1L, 20, 98327, 19823, LocalDateTime.of(2023, 5, 8, 10, 0), new Company(2L)));
//        transferRepo.save(new Transfer(2L, 20, 98327, 19823, LocalDateTime.of(2023, 5, 9, 10, 0), new Company(2L)));
//        transferRepo.save(new Transfer(3L, 20, 98327, 19823, LocalDateTime.of(2023, 3, 9, 10, 0), new Company(3L)));
//    }
}
