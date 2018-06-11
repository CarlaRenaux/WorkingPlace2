package com.example.charles.workingplace.Modele;

import java.util.ArrayList;

public class Professionel extends Utilisateur {

    private int note;



    public Professionel(){
        super();


    }

    public Professionel(String nom, String prenom, int age, String email, String mdp, int note){
        super(nom, prenom, age, email, mdp);
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

}
