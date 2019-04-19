package com.projet.bibliotheque;
public class Professeur extends Personne{
	public String cin;
	public String passWord;

	//constructeur
	public Professeur(String nom,String prenom,String cin,String passWord){
		super(nom,prenom);
		this.cin=cin;
		this.passWord=passWord;
		System.out.println("un professeur a été créer");
		
	}
	//getter


	public String getCin(){
		return this.cin;
	}
	
	public String getpassWord(){
		return this.passWord;
	}


	
	//setter


	public void setCin(){
		this.cin=cin;
	}

	//tostring

	public String toString(){
		return super.toString()+"et mon cin est:"+this.cin+".";
	}


}