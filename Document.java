package com.projet.bibliotheque;
import java.util.ArrayList;
public class Document{
	// attributs
	protected int documentNumber=0;
	public String isbn;
	public String title;
	public String authorArray[];
	public String editor;
	protected int yearOfEdition;
	protected int numberOfCopy;
	//constructeur 
	public Document(String isbn,String title,ArrayList<String> authorArray,String editor,int yearOfEdition,int numberOfCopy){
		this.isbn=isbn;
		this.title=title;
		authorArray=authorArray;
		this.editor=editor;
		this.yearOfEdition=yearOfEdition;
		this.numberOfCopy=numberOfCopy;
		documentNumber++;
		System.out.println("un document a été creer");
	}


	// setters

	public void  setIsbn(String isbn){
		this.isbn=isbn;
	}

	public void setTitle(String title){
		this.title=title;
	}	


	public void setEditor(String editor){
		this.editor=editor;
	}
	public void setYearOfEdition(int yearOfEdition){
		this.yearOfEdition=yearOfEdition;
	}
	public void setNumberOfCopy(int numberOfCopy){
		this.numberOfCopy=numberOfCopy;
	}
	public void setAuthorsArray(ArrayList<String> authorsArray){
		for(int i=0;i<authorsArray.size();i++){
			this.authorArray[i]=authorsArray.get(i);
		}
	}

	//getters


	public String getIsbn(){
		return isbn;
	}	
	public String getTitle(){
		return title;
	}
	public String getEditor(){
		return editor;
	}
	public int getYearOfEdition(){
		return yearOfEdition;
	}
	public int getNumberOfCopy(){
		return numberOfCopy;
	}
	public String[] getAuthorsArray(){
		return authorArray;
	}
	public int getDocumentNumber(){
		return documentNumber;
	}

	public String toString(){
		return ("le document que vous venez de creer a comme numero:"+this.documentNumber+" le nombre de d'exemplaire:"+this.numberOfCopy
		+" l'annee de l'edition:"+this.yearOfEdition+" le nom de l'editeur:"+this.editor+" le titre:"+this.title+" a comme isbn:"+this.isbn+"."+documentNumber); 
	}




}