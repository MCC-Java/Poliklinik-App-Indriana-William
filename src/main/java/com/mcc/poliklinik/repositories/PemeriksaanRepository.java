/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.repositories;

import com.mcc.poliklinik.entities.Pemeriksaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS-PC
 */

@Repository
public interface PemeriksaanRepository extends JpaRepository<Pemeriksaan, Integer>{
    
}
