package com.mcc.poliklinik.services;

import com.mcc.poliklinik.entities.Pasien;
import com.mcc.poliklinik.repositories.PasienRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS-PC
 */

@Service
public class PasienService {
    
    @Autowired
    PasienRepository pasienRepository;
    
    public List<Pasien> getAll() {
        return pasienRepository.findAll();
    }
    
    public void save(Pasien pasien) {
        pasienRepository.save(pasien);
    }
    
    public void delete(String id) {
        pasienRepository.delete(new Pasien(id));
    }
    
    public Pasien findById(String id) {
        return pasienRepository.findById(id).get();
    }
}
