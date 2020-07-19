/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.services;

import com.mcc.poliklinik.entities.Pemeriksaan;
import com.mcc.poliklinik.repositories.PemeriksaanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS-PC
 */

@Service
public class PemeriksaanService {
    
    @Autowired
    PemeriksaanRepository pemeriksaanRepository;
    
    public List<Pemeriksaan> getAll() {
        return pemeriksaanRepository.findAll();
    }
    
    public void save(Pemeriksaan pemeriksaan) {
        pemeriksaanRepository.save(pemeriksaan);
    }
    
    public void delete(Integer id) {
        pemeriksaanRepository.delete(new Pemeriksaan(id));
    }
    
    public void findById(Integer id) {
        pemeriksaanRepository.findById(id).get();
    }
}















