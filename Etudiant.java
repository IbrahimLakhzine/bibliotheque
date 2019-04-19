package com.projet.bibliotheque;
public class Etudiant extends Personne{
	protected String cne;
	protected String passWord;




	//constructeur
	public Etudiant(String nom,String prenom,String cne,String passWord){
		super(nom,prenom);
		this.cne=cne;
		this.passWord=passWord;
		System.out.println("un etudiant a été créer");

	}
	//getter


	public String getCne(){
		return this.cne;
	}
	public String getpassWord(){
		return this.passWord;
	}


	
	//setter


	public void setCne(){
		this.cne=cne;
	}
	

	//tostring

	public String toString(){
		return super.toString()+"et mon cne est:"+this.cne+".";
	}






}