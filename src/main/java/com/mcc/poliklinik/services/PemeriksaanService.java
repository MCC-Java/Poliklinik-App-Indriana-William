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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS-PC
 */

@Service
@Transactional
public class PemeriksaanService {
    
    @Autowired
    PemeriksaanRepository pemeriksaanRepository;
    
    public List<Pemeriksaan> getAll() {
        return pemeriksaanRepository.findAll();
    }
    
    public void save(String id, String tanggal, String deskripsi, String dokter, String pasien) {
        Integer key = Integer.parseInt(id);
        pemeriksaanRepository.savetopemeriksaan(key, tanggal, deskripsi, dokter, pasien);
    }
    
    public void delete(Integer id) {
        pemeriksaanRepository.delete(new Pemeriksaan(id));
    }
    
    public Pemeriksaan findById(Integer id) {
        return pemeriksaanRepository.findById(id).get();
    }
}
