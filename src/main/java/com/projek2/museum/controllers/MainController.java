/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projek2.museum.controllers;

import com.projek2.museum.interfaces.Data_diriInterface;
import com.projek2.museum.interfaces.RsvInterface;
import com.projek2.museum.interfaces.Tipe_tiketInterface;
import com.projek2.museum.models.Data_diri;
import com.projek2.museum.models.Rsv;
import com.projek2.museum.models.Tipe_tiket;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Asus
 */
@Controller
public class MainController {
    
    @Autowired
    private Tipe_tiketInterface tipe_tiketInterface;

    @Autowired
    private Data_diriInterface data_diriInterface;
    
    @Autowired
    private RsvInterface rsvInterface;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", rsvInterface.getAll());
        return "index";
    }

    @GetMapping("/data_diri/create")
    public String create(Model model) {
        
        Data_diri data_diri = new Data_diri();
        model.addAttribute("data_diri", data_diri);
        
        return "data_diri";
    }

    @PostMapping("/data_diri/store")
    public String store(@ModelAttribute("data_diri") Data_diri data_diri) {
        data_diriInterface.store(data_diri);
        return "redirect:/rsv/creates";
    }
    
     @GetMapping("/rsv/creates")
    public String creates(Model model) {
        
        List<Tipe_tiket> tipe_tikets = tipe_tiketInterface.getAll();
        model.addAttribute("tipe_tikets", tipe_tikets);
        
        Rsv rsv = new Rsv();
        model.addAttribute("rsv", rsv);

        return "create";
    }

    @PostMapping("/rsv/store")
    public String store(@ModelAttribute("rsv") Rsv rsv) {
        rsvInterface.store(rsv);
        return "redirect:/";
    }
    @PostMapping("/rsv/stores")
    public String stores(@ModelAttribute("rsv") Rsv rsv) {
        rsvInterface.store(rsv);
        return "redirect:/home";
    }
       @GetMapping("/rsv/{id}/edit")
         public String edit(@PathVariable(value = "id") long id, Model model) {
        List<Tipe_tiket> tipe_tikets = tipe_tiketInterface.getAll();
        model.addAttribute("tipe_tikets", tipe_tikets);
        
        Rsv rsv = rsvInterface.getById(id);

        model.addAttribute("rsv", rsv);
        return "edit";
    }


        @PostMapping("/rsv/{id}/delete")
        public String delete(@PathVariable(value = "id") long id) {
          rsvInterface.delete(id);
          return "redirect:/";
        }
        
        
        @GetMapping("/gallery")
        public String gallery (Model model) {
            return "gallery";
        }
    
        @GetMapping("/home")
        public String home (Model model) {
            return "home";
        }
    
        @GetMapping("/about")
        public String about (Model model) {
            return "about";
        }
        
}