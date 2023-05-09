/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.challenge.interbanking.repositorys;

import com.challenge.interbanking.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
import java.time.*;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Agustin Pueblas
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c FROM Company c WHERE c.fechaAdhesion >= :lastMonth")
    List<Company> findCompaniesAddLastMonth(@Param("lastMonth") LocalDateTime lastMonth);
}
