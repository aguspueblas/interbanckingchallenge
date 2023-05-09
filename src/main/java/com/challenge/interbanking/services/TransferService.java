/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.challenge.interbanking.services;

import com.challenge.interbanking.dtos.CreateTransferDto;
import com.challenge.interbanking.dtos.TransferDto;
import com.challenge.interbanking.entities.Company;
import com.challenge.interbanking.entities.Transfer;
import com.challenge.interbanking.exceptions.BusinessException;
import com.challenge.interbanking.repositorys.CompanyRepository;
import com.challenge.interbanking.repositorys.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Agustin Pueblas
 */
@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepo;

    @Autowired
    CompanyRepository companyRepo;

    public ResponseEntity<TransferDto> create(CreateTransferDto dto) throws BusinessException {
        Optional<Company> company = companyRepo.findById(dto.getIdCompania());
        if (company.isEmpty()) {
            throw new BusinessException(dto.getIdCompania(), "02", "La compania no existe en nuestros registros.", HttpStatus.CONFLICT);
        }
        Transfer entity = transferRepo.save(Transfer.fromCreateCompanyDto(dto, company.get()));
        return new ResponseEntity<>(TransferDto.fromEntity(entity, true), HttpStatus.CREATED);
    }
}
