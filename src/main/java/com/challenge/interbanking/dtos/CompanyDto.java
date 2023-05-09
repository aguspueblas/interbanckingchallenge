/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.dtos;

import com.challenge.interbanking.entities.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.*;
import lombok.Data;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Agustin Pueblas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long id;
    private Integer cuit;
    private String razonSocial;
    private LocalDateTime fechaAdhesion;

    private List<TransferDto> transferencias;

    public static CompanyDto fromEntity(Company entity, Boolean complete) {
        CompanyDto dto = new CompanyDto();
        dto.id = entity.getId();
        dto.cuit = entity.getCuit();
        dto.razonSocial = entity.getRazonSocial();
        dto.fechaAdhesion = entity.getFechaAdhesion();
        dto.transferencias = complete ? !entity.getTransfers().isEmpty() ? entity.getTransfers().stream().map(c -> TransferDto.fromEntity(c, Boolean.FALSE)).collect(Collectors.toList()) : null : null;
        return dto;
    }
}
