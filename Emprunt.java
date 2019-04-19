package com.projet.bibliotheque;
import java.util.Date; 

public class Emprunt {
	protected String isbn;
	protected Date dateEmprunt;
	protected Date dateRetour;
	protected int typeAdherent;// 0 pour le prof et 1 pour l'etudiant
	protected String codeAdherent;//cin pour le prof et cne pour l'etudiant
	
	//constructor
	public Emprunt(String isbn,Date dateEmprunt,Date dateRetour,int typeAdherent,String codeAdherent) {
		this.isbn=isbn;
		this.dateEmprunt=dateEmprunt;
		this.dateRetour=dateRetour;
		this.typeAdherent=typeAdherent;
		this.codeAdherent=codeAdherent;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getTypeAdherent() {
		return typeAdherent;
	}

	public void setTypeAdherent(int typeAdherent) {
		this.typeAdherent = typeAdherent;
	}

	public String getCodeAdherent() {
		return codeAdherent;
	}

	public void setCodeAdherent(String codeAdherent) {
		this.codeAdherent = codeAdherent;
	}
	//Tostring
	public String ToString() {
		return("l'emprunt que vous venez de creer elle a comme isbn "+this.isbn+", sa date d'emprunt est "+this.dateEmprunt+",sa date de retour est "+this.dateRetour+", son type d'adherent est"+this.typeAdherent+", son code d'adherent est"+this.codeAdherent+"");
	}
	
	
	
	
	
	
	
	
	}



