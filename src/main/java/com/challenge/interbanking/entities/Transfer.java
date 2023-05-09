/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.entities;

import com.challenge.interbanking.dtos.CreateTransferDto;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.*;
import lombok.NoArgsConstructor;
/**
 *
 * @author Agustin Pueblas
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer importe;
    private Integer cDebito;
    private Integer cCredito;
//  Se agrega en la cual se realizo la transferencia
    private LocalDateTime fecha;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_compania")
    private Company company;
    
    public static Transfer fromCreateCompanyDto(CreateTransferDto dto,Company company){
        Transfer entity = new Transfer();
        entity.importe = dto.getImporte();
        entity.cCredito = dto.getCCredito();
        entity.cDebito = dto.getCDebito();
        entity.fecha = dto.getFecha();
        entity.company = company;
        return entity;
    }
}
