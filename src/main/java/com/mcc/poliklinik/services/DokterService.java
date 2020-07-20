/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.services;

import com.mcc.poliklinik.entities.Dokter;
import com.mcc.poliklinik.repositories.DokterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS-PC
 */
@Service
public class DokterService {
    
    @Autowired
    DokterRepository dokterRepository;
    
    public List<Dokter> getAll() {
        return dokterRepository.findAll();
    }
    
    public void save(Dokter dokter) {
        dokterRepository.save(dokter);
    }
    
    public void delete(String id) {
        dokterRepository.delete(new Dokter(id));
    }
    
    public Dokter findById(String id) {
        return dokterRepository.findById(id).get();
    }
}
