package com.api.carTuning.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate productionDate;
    @Column
    private int horsePower;
    @Column(nullable = false)
    private String brand;
}
