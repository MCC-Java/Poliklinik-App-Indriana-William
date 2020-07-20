/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Pemeriksaan;
import com.mcc.poliklinik.services.PasienService;
import com.mcc.poliklinik.services.PemeriksaanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS-PC
 */
@Controller
public class PemeriksaanController {

    @Autowired
    PemeriksaanService pemeriksaanService;

    @Autowired
    PasienService pasienService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("pemeriksaan", new Pemeriksaan());
        model.addAttribute("pemeriksaans", pemeriksaanService.getAll());
        model.addAttribute("pasiens", pasienService.getAll());
        return "index";
    }

    @PostMapping("/save")
    public String save(@Valid Pemeriksaan pemeriksaan) {
        pemeriksaanService.save(pemeriksaan);
        return "redirect:/";
    }
}
