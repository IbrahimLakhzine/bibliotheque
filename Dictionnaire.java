package com.projet.bibliotheque;
import java.util.ArrayList;
public class Dictionnaire extends Document{
		protected int nbrTome;
		protected  String language;

		public Dictionnaire(String isbn,String title,ArrayList<String> authorsArray,String editor,int yearOfEdition,int numberOfCopy,int nbrTome,String language){
		super(isbn,title,authorsArray,editor,yearOfEdition,numberOfCopy);
		this.nbrTome=nbrTome;
		this.language=language;
		System.out.println("un dictionnaire a été créer");

		}


		public String toString(){
			return super.toString()+"le nombre des atome:"+nbrTome+"la langue du dictionnaire:"+language;
		}



}