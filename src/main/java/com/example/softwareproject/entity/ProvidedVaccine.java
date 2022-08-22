package com.example.softwareproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table (name = "provided_vaccine")
public class ProvidedVaccine {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn (name = "vaccine_id")
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn (name = "hospital_id")
    private Hospital hospital;

    private String amount;

    private String distributionDate;
}
