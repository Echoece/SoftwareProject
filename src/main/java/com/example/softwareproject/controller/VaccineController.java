package com.example.softwareproject.controller;


import com.example.softwareproject.entity.Vaccine;
import com.example.softwareproject.repository.VaccineRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("api/v1/vaccine")
@AllArgsConstructor
public class VaccineController {
    private final VaccineRepository vaccineRepository;

    @GetMapping
    public List<Vaccine> getAll(){
        return vaccineRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vaccine getById(@PathVariable Long id){
        return vaccineRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Vaccine save(@RequestBody Vaccine vaccine){
        return vaccineRepository.save(vaccine);
    }

    @PatchMapping
    public Vaccine update(@RequestBody Vaccine vaccine){
        return vaccineRepository.save(vaccine);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(RuntimeException::new);
        vaccineRepository.delete(vaccine);
    }
}
