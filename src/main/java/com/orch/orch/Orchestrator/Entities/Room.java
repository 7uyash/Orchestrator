package com.orch.orch.Orchestrator.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private double pricePerMonth;
    private String languages;
    private double distanceFromCampus;
}