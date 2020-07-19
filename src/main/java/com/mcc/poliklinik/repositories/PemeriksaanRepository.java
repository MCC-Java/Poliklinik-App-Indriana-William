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
