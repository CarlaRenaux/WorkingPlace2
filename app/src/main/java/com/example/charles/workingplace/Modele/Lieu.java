package com.example.charles.workingplace.Modele;


import java.util.HashMap;

public class Lieu {



    private String adresse;
    private int capacite;
    private String description;
    private boolean statut;
    private int id;
    private String ville;
    private int codepostal;
    private HashMap<String, String>calendrier;
    private String date;
    private String heure;
    private String heureFin;

    public Lieu(){
        adresse = "Inconnu";
        ville = "Inconnu";
        codepostal = 0;
        capacite = 0;
        description = "Inconnu";
        statut= false;
        id = 0;
        date = "Inconnu";
        heure = "Inconnu";
        heureFin = "Inconnu";

        calendrier = new HashMap<String, String>();
    }
    public Lieu(String adresse, String ville, int codepostal, int capacite, String description, int id, String date, String heure, String heureFin){

        this.adresse = adresse;
        this.capacite = capacite;
        this.description= description;
        this.id = id;
        this.ville = ville;
        this.codepostal = codepostal;
        this.date = date;
        this.heure = heure;
        this.heureFin = heureFin;

        calendrier = new HashMap<String, String>();


    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getHeureFin(){
        return heureFin;
    }

    public String getVille() { return ville; }

    public void setVille(String ville) { this.ville = ville; }

    public int getCodepostal() { return codepostal; }

    public void setCodepostal(int codepostal) { this.codepostal = codepostal; }

    public HashMap<String, String> getCalendrier() {
        return calendrier;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean getStatut() {
        return statut;
    }
    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    public int getId() {
        return id;
    }







}
