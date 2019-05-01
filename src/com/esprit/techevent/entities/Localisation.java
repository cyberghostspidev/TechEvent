/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.entities;

/**
 *
 * @author Yacine Ben Ouirane
 */
public class Localisation {

    private int idLocalisation;
    private String descritpionPlace;
    private double latitude;
    private double longitude;
    private int capacite;

    public Localisation() {
    }

    public Localisation(String descritpionPlace, double latitude, double longitude, int capacite) {
        this.descritpionPlace = descritpionPlace;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacite = capacite;
    }

    public Localisation(int idLocalisation, String descritpionPlace, double latitude, double longitude, int capacite) {
        this.idLocalisation = idLocalisation;
        this.descritpionPlace = descritpionPlace;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capacite = capacite;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public String getDescritpionPlace() {
        return descritpionPlace;
    }

    public void setDescritpionPlace(String descritpionPlace) {
        this.descritpionPlace = descritpionPlace;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

}
