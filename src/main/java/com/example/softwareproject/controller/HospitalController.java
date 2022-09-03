package com.example.softwareproject.controller;

import com.example.softwareproject.entity.Hospital;
import com.example.softwareproject.repository.HospitalRepository;
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
@RequestMapping ("api/v1/hospitals")
@AllArgsConstructor
public class HospitalController {
    private final HospitalRepository hospitalRepository;

    @GetMapping
    public List<Hospital> getAll(){
        return hospitalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hospital getById(@PathVariable Long id){
        return hospitalRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Hospital save(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @PatchMapping
    public Hospital update(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
        Hospital vaccine = hospitalRepository.findById(id).orElseThrow(RuntimeException::new);
        hospitalRepository.delete(vaccine);
    }
}
