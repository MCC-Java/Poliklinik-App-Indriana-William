/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Dokter;
import com.mcc.poliklinik.services.DokterService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS-PC
 */
@Controller
public class DokterController {
    
    @Autowired
    DokterService dokterService;
    
    @GetMapping("/dokter")
    public String dokter(Model model) {
        model.addAttribute("dokter", new Dokter());
        model.addAttribute("dokters", dokterService.getAll());
        return "dokter";
    }
    
    @PostMapping("/dokter/save")
    public String save(@Valid Dokter dokter) {
        dokterService.save(dokter);
        return "redirect:/dokter";
    }
    
    @GetMapping("/dokter/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("dokter", dokterService.findById(id));
        model.addAttribute("dokters", dokterService.getAll());
        return "dokter";
    }
    
    @GetMapping("/Dokter/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        dokterService.delete(id);
        return "redirect:/dokter";
    }
}
