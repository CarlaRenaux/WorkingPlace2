package com.example.charles.workingplace.Modele;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilisateur {

	ArrayList<Lieu> listeLieux = new ArrayList<Lieu>();
	
	protected String nom;
	protected String prenom;
	protected int age;
	//Dictionnaire d'identifiant (clé, valeur) (String, String) (email, mdp)
	protected HashMap<String, String> listeIdentifiant;
	protected String email;
	protected String mdp;

	
	//constructeur par defaut 
	public Utilisateur(){
		nom = "Inconnu";
		prenom = "Inconnu";
		age = 0;
		listeIdentifiant = new HashMap<String, String>();
		email = "Inconnu";
		mdp = "Inconnu";

	}
	
	
	//Constructeur avec parametre pour attribuer des nouvelles valeurs aux attributs de la classe Utilisateur
	public Utilisateur(String nom, String prenom, int age, String email, String mdp){
		this.nom = nom;
		this.prenom= prenom;
		this.age = age;
		this.email =email;
		this.mdp = mdp;
		//Ajout (clé, valeur) (String, String) (email, mdp) dans le dictionnaire
		//listeIdentifiant.put(email, mdp);
		
	}


	public ArrayList<Lieu> getListeLieux() {
		return listeLieux;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String recupererNom() {
		return this.nom;
	}
	public void modifierNom(String nom) {
		this.nom = nom;
	}
	public String recupererPrenom() {
		return prenom;
	}
	public void modifierPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int recupererAge() {
		return age;
	}
	public void modifierAge(int age) {
		this.age = age;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp){
		this.mdp = mdp;
	}





}
