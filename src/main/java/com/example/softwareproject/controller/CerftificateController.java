package com.example.softwareproject.controller;

import com.example.softwareproject.entity.Certificate;
import com.example.softwareproject.repository.CertificateRepository;
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
@RequestMapping ("api/v1/certificates")
@AllArgsConstructor
public class CerftificateController {
    private final CertificateRepository certificateRepository;

    @GetMapping
    public List<Certificate> getAll(){
        return certificateRepository.findAll();
    }

    @GetMapping("/{id}")
    public Certificate getById(@PathVariable Long id){
        return certificateRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Certificate save(@RequestBody Certificate certificate){
        return certificateRepository.save(certificate);
    }

    @PatchMapping
    public Certificate update(@RequestBody Certificate certificate){
        return certificateRepository.save(certificate);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Certificate certificate){
        certificateRepository.delete(certificate);
    }
}
