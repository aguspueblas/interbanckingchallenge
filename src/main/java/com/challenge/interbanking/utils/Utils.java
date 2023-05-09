/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.interbanking.utils;

import java.time.*;

/**
 *
 * @author Agustin Pueblas
 */
public class Utils {

    public static LocalDateTime getLastMonth() {
        return LocalDateTime.now().minusMonths(1);

    }
}
