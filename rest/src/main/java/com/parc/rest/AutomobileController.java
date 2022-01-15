package com.parc.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AutomobileController {
    @Autowired
    private AutomobileRepository automobileRepository;

    @GetMapping("/")
    public List<Automobile> gAutomobile(){
        return automobileRepository.findAll();
    }

    @GetMapping("/{id}")
    public Automobile gAutomobile(@PathVariable String id){
        return automobileRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Automobile pAutomobile(@RequestBody Automobile automobile){
        return automobileRepository.save(automobile);
    }


    @PutMapping("/{id}")
    public Automobile putaAutomobile(@PathVariable String id, @RequestBody Automobile automobile) {
        Automobile oldauto = automobileRepository.findById(id).orElse(null);
        oldauto.setCategorie(automobile.getCategorie());
        oldauto.setMatricule(automobile.getMatricule());
        oldauto.setEtat(automobile.getEtat());
        oldauto.setModel(automobile.getModel());
        oldauto.setMarque(automobile.getMarque());

        return automobileRepository.save(oldauto);
    }

    @DeleteMapping("/{id}")
    public String deleteAutomobiliString(@PathVariable String id){
        automobileRepository.deleteById(id);
        return id;
    }









}
