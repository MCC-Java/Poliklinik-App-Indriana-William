package com.mcc.poliklinik.repositories;

import com.mcc.poliklinik.entities.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS-PC
 */
@Repository
public interface PasienRepository extends JpaRepository<Pasien, String>{
    
}
