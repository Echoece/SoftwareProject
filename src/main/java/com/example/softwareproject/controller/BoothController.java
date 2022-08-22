package com.example.softwareproject.controller;

import com.example.softwareproject.entity.Booth;
import com.example.softwareproject.repository.BoothRepository;
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
@RequestMapping ("api/v1/booth")
@AllArgsConstructor
public class BoothController {
    private final BoothRepository boothRepository;

    @GetMapping
    public List<Booth> getAll(){
        return boothRepository.findAll();
    }

    @GetMapping("/{id}")
    public Booth getById(@PathVariable Long id){
        return boothRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Booth save(@RequestBody Booth booth){
        return boothRepository.save(booth);
    }

    @PatchMapping
    public Booth update(@RequestBody Booth booth){
        return boothRepository.save(booth);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Booth booth){
        boothRepository.delete(booth);
    }
}
