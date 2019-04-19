package com.projet.bibliotheque;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
public class All {
	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		//graphical interface
		//String nom="ibr",prenom="ibr",cne="5",password="paris";
		//Etudiant et=new Etudiant(nom,prenom,cne,password);
		//ArrayList<String> info=new ArrayList<String>();
		Bibliotheque biblio=new Bibliotheque();
		biblio.authentification();
	
	
		//sql things
		
		
		
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
		//Statement st=con.createStatement();
		//rs=st.executeQuery("INSERT INTO etudiant VALUES('dc37067','moalige','salim','azerty')");
		//st.close();
		PreparedStatement posted=con.prepareStatement("delete from etudiant where nom='' "); 
		posted.executeUpdate();
		con.close();*/
		
		
		
		
		
		
	/*
		// le code
		ArrayList<Emprunt> listeEmprunts=new ArrayList<Emprunt>();
		InfoProfesseur ip=new InfoProfesseur();
		InfoEtudiant ie=new InfoEtudiant();
		ArrayList<InfoProfesseur> infoProfesseur=new ArrayList<InfoProfesseur>();
		ArrayList<InfoEtudiant> infoEtudiant=new ArrayList<InfoEtudiant>();
		infoProfesseur.add(ip);
		infoEtudiant.add(ie);
		String isbn="isbn";
		String title="pereriche";
		String editor="editor";
		int yearOfEdition=2018;
		int numberOfCopy=2;
		String prenom="aymen";
		String nom="lala";
		int id=1;
		String cne="R13955121";
		String cin="BK157864";
		Etudiant e=new Etudiant(nom,prenom,id,cne);
		Professeur p=new Professeur(nom,prenom,id,cin);
		ArrayList<String> authorArray=new ArrayList<String>();
		
		authorArray.add("salim");
		authorArray.add("ibra");
		Document d=new Document(isbn,title,authorArray,editor,yearOfEdition,numberOfCopy);
		ArrayList<Document> listeDocuments=new ArrayList<Document>();
		listeDocuments.add(d);
		ArrayList<Etudiant> listeEtudiant=new ArrayList<Etudiant>();
		listeEtudiant.add(e);
		ArrayList<Professeur> listeProfesseur=new ArrayList<Professeur>();
		listeProfesseur.add(p);
		Bibliotheque b=new Bibliotheque(listeDocuments,listeEtudiant,listeProfesseur,infoProfesseur,infoEtudiant,listeEmprunts);
		Etudiant e1= b.getEtudiantByCne(cne);
		String a=e1.getPrenom();
		System.out.println(a+" \n"+b.trierAnneAsc());
		System.out.println(b.passWordGenerator());
		*/
}

}
