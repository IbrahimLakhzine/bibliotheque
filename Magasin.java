package com.projet.bibliotheque;
import java.util.ArrayList;
public class Magasin extends Document{
	protected int periodicity;
	protected int  mounth;
	protected int day;

	public Magasin(String isbn,String title,ArrayList<String> authorsArray,String editor,int yearOfEdition,int numberOfCopy,int periodicity,int mounth,int day){
		super(isbn,title,authorsArray,editor,yearOfEdition,numberOfCopy);
		this.periodicity=periodicity;
		this.mounth=mounth;
		this.day=day;
		System.out.println("une magasine a été créer");
		
	}

	public String toString(){
		return super.toString()+"la periodicity du Magasine est:"+periodicity+"le mois de sortie:"+mounth+"le jour de sortie:"+day;
	}
}