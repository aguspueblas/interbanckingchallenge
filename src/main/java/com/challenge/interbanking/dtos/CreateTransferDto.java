/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.dtos;

import lombok.Data;
import java.time.*;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Agustin Pueblas
 */
@Data
public class CreateTransferDto {
    @NotNull
    private Integer importe;
    @NotNull
    private Integer cDebito;
    @NotNull
    private Integer cCredito;
    @NotNull
    private Long idCompania;
    private LocalDateTime fecha;
}
