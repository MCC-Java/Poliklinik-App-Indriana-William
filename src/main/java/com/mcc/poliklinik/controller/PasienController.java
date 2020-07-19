package com.mcc.poliklinik.controller;

import com.mcc.poliklinik.entities.Pasien;
import com.mcc.poliklinik.services.PasienService;
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
public class PasienController {
    
    @Autowired
    PasienService pasienService;
    
    @GetMapping("/pasien")
    public String pasien(Model model) {
        model.addAttribute("pasien", new Pasien());
        model.addAttribute("pasiens", pasienService.getAll());
        return "pasien";
    }
    
    @PostMapping("/pasien/save")
    public String save(@Valid Pasien pasien) {
        pasienService.save(pasien);
        return "redirect:/pasien";
    }
    
    @GetMapping("/pasien/{id}")
    public String getById(Model model, @PathVariable("id") String id) {
        model.addAttribute("pasien", pasienService.findById(id));
        model.addAttribute("pasiens", pasienService.getAll());
        return "pasien";
    }
    
    @GetMapping("/pasien/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id) {
        pasienService.delete(id);
        return "redirect:/pasien";
    }
}
