/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.entities;

import com.challenge.interbanking.dtos.CreateCompanyDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import java.time.*;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Agustin Pueblas
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer cuit;
    private String razonSocial;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaAdhesion;

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Transfer> transfers;
    
    public Company(Long id){
        this.id = id;
    }
    
    public static Company fromCreateCompanyDto(CreateCompanyDto dto){
        Company entity = new Company();
        entity.cuit = dto.getCuit();
        entity.razonSocial = dto.getRazonSocial();
        entity.fechaAdhesion = dto.getFechaAdesion();
        return entity;
    }
}
