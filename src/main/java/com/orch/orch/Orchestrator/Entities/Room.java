package com.orch.orch.Orchestrator.Entities;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;

    public Room() {
    }

    public Room(String location, double pricePerMonth, String languages, double distanceFromCampus) {
        this.location = location;
        this.pricePerMonth = pricePerMonth;
        this.languages = languages;
        this.distanceFromCampus = distanceFromCampus;
    }

    private double pricePerMonth;
    private String languages;
    private double distanceFromCampus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public double getDistanceFromCampus() {
        return distanceFromCampus;
    }

    public void setDistanceFromCampus(double distanceFromCampus) {
        this.distanceFromCampus = distanceFromCampus;
    }
}