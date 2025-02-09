package com.api.carTuning.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int productionDate;
    @Column
    private int horsePower;
    @Column(nullable = false)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "cutomer_id", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tuning> tunings;
}
