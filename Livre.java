package com.projet.bibliotheque;
import java.util.ArrayList;
public class Livre extends Document{
	protected int nbrpage;
	protected String type;
	protected String tome;

	public Livre(String isbn,String title,ArrayList<String> authorsArray,String editor,int yearOfEdition,int numberOfCopy,int nbrpage,String type,String tome){
		super(isbn ,title,authorsArray,editor,yearOfEdition,numberOfCopy);
		this.nbrpage=nbrpage;
		this.type=type;
		this.tome=tome;
		System.out.println("un livre a été créer");
	}

	public String toString(){
		return super.toString()+"le nombre de page du livre est :"+nbrpage+"le type du livre:"+type+"le tome du livre:"+tome;
	}
	
}