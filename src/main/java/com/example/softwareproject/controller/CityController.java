package com.example.softwareproject.controller;

import com.example.softwareproject.entity.City;
import com.example.softwareproject.repository.CityRepository;
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
@RequestMapping ("api/v1/cities")
@AllArgsConstructor
public class CityController {
    private final CityRepository cityRepository;

    @GetMapping
    public List<City> getAll(){
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id){
        return cityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public City save(@RequestBody City city){
        return cityRepository.save(city);
    }

    @PatchMapping
    public City update(@RequestBody City city){
        return cityRepository.save(city);
    }

    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id){
        City vaccine = cityRepository.findById(id).orElseThrow(RuntimeException::new);
        cityRepository.delete(vaccine);
    }
}
