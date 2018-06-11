package com.example.charles.workingplace.Controleur;


import com.example.charles.workingplace.Modele.Etudiant;
import com.example.charles.workingplace.Modele.Lieu;
import com.example.charles.workingplace.Modele.Professionel;
import com.example.charles.workingplace.Modele.Utilisateur;

import java.util.ArrayList;

public class Controleur {

    private int id =0;
    //Liste des utilisateirs
    private static ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
    private static Lieu lieuSelectionner = new Lieu();




    private static Utilisateur utilisateurCourant = new Utilisateur();



    public Etudiant creerEtudiant(String nom, String prenom, int age, String email, String mdp){
        //Création nouvel etudiant via constructeur dynamique
        Etudiant utilisateur = new Etudiant(nom, prenom, age, email, mdp);
        //Ajout dans la liste d'etudiant
        listeUtilisateur.add(utilisateur);
        return utilisateur;
    }




    public Professionel creerProfessionnel(String nom, String prenom, int age, String email, String mdp){
        //Création nouvel pro via constructeur dynamique
        Professionel utilisateur = new Professionel(nom, prenom, age, email, mdp, 5);
        //Ajout dans la liste d'etudiant
        listeUtilisateur.add(utilisateur);
        return utilisateur;
    }

    public Lieu creerLieu(String adresse, String ville, int codepostale, int capacite, String description, String date, String heure, String heureFin) {

        Lieu lieu = new Lieu(adresse, ville, codepostale, capacite, description, id, date, heure, heureFin);
        lieu.getCalendrier().put(date,heure+" jusqu'à "+heureFin);
        utilisateurCourant.getListeLieux().add(lieu);
        id = id + 1;

        return lieu;
    }





    //Fonction supprimer un utilisateur qui prend en parametre un email que je tape
    public Utilisateur supprimerUtilisateur(String email){
        Utilisateur utilisateur = new Utilisateur();
        //Je parcours ma liste d'utilisateur (i va prendre la valeur de chaque utilisateur)
        for(Utilisateur i : listeUtilisateur){
            //Si un des utilisateur a le meme email que celui que je donne en paramêtre
            if(i.getEmail() == email ){
                //Je supprime cet utilisateur (objet entier)
                utilisateur = i;
                listeUtilisateur.remove(i);



            }


        }
        return utilisateur;




    }

    public Utilisateur afficherUtilisateur(String email){//aaaabbb
        //On demande un email en parametre

        //On déclare un utilisateur temporaire pour récuperer le bon dans la liste
        Utilisateur utilisateur = new Utilisateur();




        //On parcours notre liste d'etudiant
        for(Utilisateur i : listeUtilisateur ){
            //je vérifie si l'etudiant (i) a le meme email que celui donné en parametre
            if(i.getEmail() == email){
                utilisateur = i;
            }

            System.out.println(i.getEmail());
        }
        //Je retourne l'utilisateur trouvé
        return utilisateur;
    }



    public ArrayList<Utilisateur> getListeUtilisateur(){
        return listeUtilisateur;
    }

    public void setUtilisateurCourant(Utilisateur utilisateur){
        this.utilisateurCourant = utilisateur;
    }

    public Utilisateur getUtilisateurCourant(){return utilisateurCourant;}


    public boolean verifierMdp(String mdp1, String mdp2 ){

        if(mdp1.equals(mdp2)){
            return true;
        }

        else{
            return false;
        }
        //return mdp1.equals(mdp2);

    }

    public Lieu getLieuSelectionner() {
        return this.lieuSelectionner;
    }

    public void setLieuSelectionner(Lieu lieuSelectionner) {
        this.lieuSelectionner = lieuSelectionner;
    }
}



