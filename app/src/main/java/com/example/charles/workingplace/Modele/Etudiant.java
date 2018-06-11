package com.example.charles.workingplace.Modele;

import java.util.ArrayList;

public class Etudiant extends Utilisateur {
	

	
	
	public Etudiant(){
		//Appeller le constructeur de la classe mère (Utilisateur)
		super();
		//email est connu car Etudiant est une classe fille de Utilisateur (Etudiant hérite de Utilisateur) 
		email = "czerfgh@dfert.fr";
		
	}
	
	public Etudiant(String nom, String prenom, int age, String email, String mdp){
		//Appeller le constructeur dynamique de la classe mère (Utilisateur)
		super(nom, prenom, age, email, mdp);
	
	}

}
