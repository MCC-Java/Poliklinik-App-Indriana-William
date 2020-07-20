/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.repositories;

import com.mcc.poliklinik.entities.Pemeriksaan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS-PC
 */

@Repository
public interface PemeriksaanRepository extends JpaRepository<Pemeriksaan, Integer>{
    
    @Modifying
    @Query(value = "INSERT INTO pemeriksaan VALUES (?1,?2,?3,?4,?5)", nativeQuery=true)
    void savetopemeriksaan(Integer id, String tanggal, String deskripsi, String dokter, String pasien);
}
