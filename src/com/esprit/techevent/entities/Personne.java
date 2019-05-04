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
public class Personne {

    private int idPersonne;
    private String nom;
    private String prenom;
    private int age;
    private String profession;
    private int idUtilisateur;

    public Personne() {
    }

    public Personne(String nom, String prenom, int age, String profession, int idUtilisateur) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.profession = profession;
        this.idUtilisateur = idUtilisateur;
    }

    public Personne(int idPersonne, String nom, String prenom, int age, String profession, int idUtilisateur) {
        this.idPersonne = idPersonne;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.profession = profession;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
