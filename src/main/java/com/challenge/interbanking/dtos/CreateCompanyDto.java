/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.dtos;
import java.time.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author Agustin Pueblas
 */
@Data
public class CreateCompanyDto {
    @NotNull
    private Integer cuit;
    @NotBlank
    private String razonSocial;
    private LocalDateTime fechaAdesion;
}
