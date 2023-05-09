/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.dtos;

import com.challenge.interbanking.entities.Company;
import com.challenge.interbanking.entities.Transfer;
import lombok.Data;
import java.time.*;
/**
 *
 * @author Agustin Pueblas
 */
@Data
public class TransferDto {

    private Long id;
    private Integer importe;
    private Integer cDebito;
    private Integer cCredito;
    private CompanyDto compania;
    private LocalDateTime fecha;
    public static TransferDto fromEntity(Transfer entity, Boolean complete) {
        TransferDto dto = new TransferDto();
        dto.id = entity.getId();
        dto.importe = entity.getImporte();
        dto.cCredito = entity.getCCredito();
        dto.cDebito = entity.getCDebito();
        dto.compania = complete ? CompanyDto.fromEntity(entity.getCompany(),Boolean.TRUE) : null;
        dto.fecha = entity.getFecha();
        return dto;
    }
;
}
