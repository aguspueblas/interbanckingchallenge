/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.challenge.interbanking.repositorys;

import com.challenge.interbanking.entities.Company;
import com.challenge.interbanking.entities.Transfer;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Agustin Pueblas
 */
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    @Query("SELECT DISTINCT t.company FROM Transfer t WHERE t.fecha >= :lastMonth")
    List<Company> findCompaniesWithTransfersLastMonth(@Param("lastMonth") LocalDateTime lastMonth);
}
