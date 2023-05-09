/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Agustin Pueblas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandarizedApiExceptionResponse {
    @ApiModelProperty(required = true, name = "type")
    private String type = "error";
    private String title;
    private String code;
    private String detail;
}
