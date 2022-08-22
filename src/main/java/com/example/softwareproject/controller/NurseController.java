package com.example.softwareproject.controller;


import com.example.softwareproject.entity.Nurse;
import com.example.softwareproject.repository.NurseRepository;
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
@RequestMapping("api/v1/nurse")
@AllArgsConstructor
public class NurseController {
    private final NurseRepository nurseRepository;

    @GetMapping
    public List<Nurse> getAll(){
        return nurseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Nurse getById(@PathVariable Long id){
        return nurseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Nurse save(@RequestBody Nurse nurse){
        return nurseRepository.save(nurse);
    }

    @PatchMapping
    public Nurse update(@RequestBody Nurse nurse){
        return nurseRepository.save(nurse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Nurse nurse){
        nurseRepository.delete(nurse);
    }


}
