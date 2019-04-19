package com.projet.bibliotheque;
public class Personne{
	protected String nom;
	protected String prenom;
	protected int id=0;


	//constructeur
	public Personne(String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		id++;
		System.out.println("une personne a été créer");
	
	}
	
	
	//getter 
	
	
	public String getNom() {
		return this.nom; 
	}
	
	
	public String getPrenom() {
		return this.prenom; 
	}
	
	public int  getId() {
		return this.id ; 
	}
	
	//setter
	
	public void  setNom(String nom) {
		this.nom=nom; 
	}
	
	public void  setPrenom(String prenom) {
		this.prenom=prenom; 
	}
	
	
	public void  setId(int id) {
		this.id=id; 
	}


	

}