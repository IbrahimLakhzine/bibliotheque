
package com.projet.bibliotheque;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import com.mysql.cj.jdbc.*; 
import java.util.Comparator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java .lang.Math;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Bibliotheque implements Password,AllAboutLogin {
	protected ArrayList<Document> listeDocuments;
	protected ArrayList<Emprunt> listeEmprunts;
	protected ArrayList<Professeur> infoProfesseur;
	protected ArrayList<Etudiant> infoEtudiant; 
	
	//constructeur
	public Bibliotheque() throws SQLException{
		listeDocuments=new ArrayList<Document>();
		listeEmprunts=new ArrayList<Emprunt>();
		infoProfesseur=new ArrayList<Professeur>();
		infoEtudiant=new ArrayList<Etudiant>();
	}

	public Bibliotheque(ArrayList<Document> listeDocuments){
		
		this.listeDocuments=listeDocuments;

		
		//this.infoProfesseur=infoProfesseur;
		
		//this.infoEtudiant=infoEtudiant;
		
		//this.listeEmprunts=listeEmprunts;
		
		System.out.println("une bibliotheque a été créer");

	}
	
	public void setListeDocuments(ArrayList<Document> listeDocuments) {		
		this.listeDocuments=listeDocuments;
	}
	
	public void setListeEmprunts(ArrayList<Emprunt> listeEmprunts) {		
		this.listeEmprunts=listeEmprunts;
	}
	
	public void setInfoEtudiant(ArrayList<Etudiant> listeEtudiant) {		
		this.infoEtudiant=listeEtudiant;
	}
	
	public void setInfoProfesseur(ArrayList<Professeur> listeProfesseur) {		
		this.infoProfesseur=listeProfesseur;
	}
	


	
	public String toString(){
		String myString="les documents que la Bibliotheque contient: ";
		for(int i=0;i<listeDocuments.size();i++) {
			myString=myString+listeDocuments.get(i)+"-"; 
		}

		myString=myString+"et les etudiants sont: ";

		for(int i=0;i<infoEtudiant.size();i++){
			myString=myString+infoEtudiant.get(i)+"-"; 
		}
		myString+="et les professeurs sont:";
		
		for(int i=0;i<infoProfesseur.size();i++){
			myString=myString+infoProfesseur.get(i)+"-"; 
		}
		myString+="et les emprunteurs sont:";
		
		for(int i=0;i<listeEmprunts.size();i++){
			myString=myString+listeEmprunts.get(i)+"-"; 
		}
		return myString;
	}

	public Etudiant getEtudiantByCne(String cne){
		for(int i=0;i<this.infoEtudiant.size();i++){
			if(this.infoEtudiant.get(i).cne.equals(cne)){
				return this.infoEtudiant.get(i);
			}
		}
		return null;
	}

	public Professeur getProfesseurByCin(String cin){
		for(int i=0;i<infoProfesseur.size();i++){
			if(infoProfesseur.get(i).cin.equals(cin)){
				return infoProfesseur.get(i);
			}
		}
		return null;
	}

	public Document getDocumentByEditeur(String editor){
		for(int i=0;i<listeDocuments.size();i++){
			if(listeDocuments.get(i).editor.equals(editor)){
				return listeDocuments.get(i);
			}
		}
		return null;
	}
	public Document getDocumentByISBN(String isbn){
		for(int i=0;i<listeDocuments.size();i++){
			if(listeDocuments.get(i).isbn==isbn){
				return listeDocuments.get(i);
			}
		}
		return null;
	}
	public Document getDocumentByAuteur(String auteur){
		for(int i=0;i<listeDocuments.size();i++){
			for(int j=0;j<listeDocuments.get(i).authorArray.length;j++) {
				if(listeDocuments.get(i).authorArray[j].equals(auteur)) {
					return listeDocuments.get(i);
				}
			}
			
		}
		return null;
	}
	public Document getDocumentByTitre(String titre){
		for(int i=0;i<listeDocuments.size();i++){
			if(listeDocuments.get(i).title.equals(titre)){
				return listeDocuments.get(i);
			}
		}
		return null;

	}
	
	public boolean SupprimerDocument(String titre){
		boolean flag=false;
		for( int i=0;i<listeDocuments.size();i++){
			if(!listeDocuments.get(i).title.equals(titre)){
				listeDocuments.remove(listeDocuments.get(i));
				flag=true;
			}
		}
		if(flag==true) {
			return true;
		}
		else {
			return false; 
		}
		
	}
	
	
	/*public boolean SupprimerEtudiant(String cne){
		boolean flag=false;
		for( int i=0;i<infoEtudiant.size();i++){
			if(infoEtudiant.get(i).cne.equals(cne)){
				infoEtudiant.remove(infoEtudiant.get(i));
				flag=true;
			}
			
		}
		
		for(Emprunt emp:this.listeEmprunts) {
			if(emp.codeAdherent.equals(cne)) {
				rendreDocument(emp.isbn);
			}
			
		}
		
		if(flag==true) {
			return true;
		}
		else {
			return false;
		}
		
	}*/
	
	
	/*public boolean SupprimerProfesseur(String cin){
		boolean flag=false;
		for( int i=0;i<infoProfesseur.size();i++){
			if(infoProfesseur.get(i).cin.equals(cin)){
				infoProfesseur.remove(infoProfesseur.get(i));
				flag=true;
			}
			
		}
		
		for(Emprunt emp:this.listeEmprunts) {
			if(emp.codeAdherent.equals(cin)) {
				rendreDocument(emp.isbn);
			}
			
		}
		if(flag==true) {
			return true;
		}
		else {
			return false;
		}
		
	}*/
	
	
	
	public boolean AjouterDocument(Document d){
		for(Document doc:this.listeDocuments) {
			if(doc.isbn.equals(d.isbn)) {
				return false;
			}
		}
			listeDocuments.add(d);
			return true;
	}
	
	
	
	
	public boolean AjouterEtudiant(Etudiant etudiant) {
		for(Etudiant etd:infoEtudiant) {
			if(etd.cne.equals(etudiant.cne)) {
				return false;
			}
		}
		
		infoEtudiant.add(etudiant);
		return true;
	}
	
	
	public boolean AjouterProfesseur(Professeur p) {
		for(Professeur prof:infoProfesseur) {
			if(prof.cin.equals(p.cin)) {
				return false;
			}}
		infoProfesseur.add(p);
		return true;
	}
	
	
	public ArrayList<Document> trierAnneAsc() {
		ArrayList<Integer> listeYearOfEdition=new ArrayList<Integer>();
		ArrayList<Document> listeDoc=new ArrayList<Document>();
		
		for(int i=0;i<listeDocuments.size();i++){
			listeYearOfEdition.add(listeDocuments.get(i).yearOfEdition);
		}
		listeYearOfEdition.sort(Comparator.naturalOrder());
		
		for(Document doc:listeDocuments) {
			for(int i=0;i<listeYearOfEdition.size();i++) {
				if(doc.yearOfEdition==listeYearOfEdition.get(i)) {
					listeDoc.add(doc);
				}
			}
			
		}
		return listeDoc;
	}
	
	//passwordgenerator
	
	public String passWordGenerator() {
		String passWord="";
		ArrayList<Integer> listInt= new ArrayList<Integer>();
		ArrayList<String> Alphabet= new ArrayList<String>();
		Alphabet.add("a");Alphabet.add("b");Alphabet.add("c");Alphabet.add("d");Alphabet.add("e");Alphabet.add("f");Alphabet.add("g");Alphabet.add("h");Alphabet.add("i");Alphabet.add("j");Alphabet.add("k");Alphabet.add("l");Alphabet.add("m");Alphabet.add("n");Alphabet.add("o");Alphabet.add("p");Alphabet.add("q");Alphabet.add("r");Alphabet.add("s");Alphabet.add("t");Alphabet.add("u");Alphabet.add("v");Alphabet.add("w");Alphabet.add("x");Alphabet.add("y");Alphabet.add("z");

		for(int i=0;i<8;i++) {
			listInt.add((int)(Math.random()*26));
		}
		
		
		for(int i=0;i<8;i++) {
			passWord+=Alphabet.get(listInt.get(i));
		}
		
		
		return passWord;
	}
	
	public void identifierEtudiant() {
		
		Dimension dim=new Dimension(100,25);
		JFrame win=new JFrame();
		Label cneLabel=new Label("cne:");
		Label nameLabel=new Label("name:");
		Label prenomLabel=new Label("prenom:");
		JTextField name=new JTextField();
		JTextField prenom=new JTextField();
		JTextField cne=new JTextField();
		JPanel pan=new JPanel();
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JButton previous=new JButton("previous page");
		pan1.setPreferredSize(new Dimension(100,80));
		pan1.setBackground(Color.yellow);
		JButton sign=new JButton("Sign up");
		name.setPreferredSize(dim);
		prenom.setPreferredSize(dim);
		cne.setPreferredSize(dim);
		pan2.add(previous);
		pan.add(cneLabel);
		pan.add(cne);
		pan.add(nameLabel);
		pan.add(name);
		pan.add(prenomLabel);
		pan.add(prenom);
		pan.add(sign);
		win.add(pan2,BorderLayout.SOUTH);
		win.add(pan,BorderLayout.CENTER);
		win.add(pan1,BorderLayout.WEST);
		win.setTitle("Bibliotheque");
		win.setLocation(500,100);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(450,400);
		win.setVisible(true);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.setVisible(false);
				authentification();
				
			}
			
		});
		
		sign.addActionListener(new ActionListener() {
			boolean flag=false;
			String nameinscri,prenominscri,cneinscri,passWordinscri;
			public void actionPerformed(ActionEvent arg0) {
				nameinscri=name.getText();
				prenominscri=prenom.getText();
				cneinscri=cne.getText();
				passWordinscri=passWordGenerator();
				if(!(nameinscri.equals("") && prenominscri.equals("") && cneinscri.equals(""))) {
					Etudiant infoEtudiant=new Etudiant(nameinscri,prenominscri,cneinscri,passWordinscri);
					AjouterEtudiant(infoEtudiant);
					
					//sql
					try {
						String cne,prenom,nom;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from etudiant");
						while(rs.next()) {
							cne=rs.getString("cne");
							nom=rs.getString("nom");
							prenom=rs.getString("prenom");
							if(cneinscri.equals(cne) && nameinscri.equals(nom) && prenominscri.equals(prenom)) {
								flag=true;
								break;
							}
						}
						con.close();
						st.close();
					} catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					} 

					if(flag==true) {
						Dimension dim=new Dimension(100,25);
						JFrame win=new JFrame();
						Label qLabel=new Label("que voulez vous faire?");
						JComboBox<String>  rep=new JComboBox<String>();
						JButton previous=new JButton("previous page");
						JPanel pan=new JPanel();
						JPanel pan1=new JPanel();
						JPanel pan2=new JPanel();
						rep.addItem("emprunter un document");
						rep.addItem("se desabonner");
						rep.addItem("changer de mot de pass");
						rep.addItem("rendre un document");
						rep.addItem("chercher un document par isbn");
						rep.addItem("chercher un document par titre");
						rep.addItem("chercher un document par auteur");
						pan1.setPreferredSize(new Dimension(100,80));
						pan1.setBackground(Color.green);
						JButton sign=new JButton("Submit");
						rep.setPreferredSize(dim);
						pan2.add(previous);
						pan.add(qLabel);
						pan.add(rep);
						pan.add(sign);
						win.add(pan,BorderLayout.CENTER);
						win.add(pan1,BorderLayout.WEST);
						win.add(pan2,BorderLayout.SOUTH);
						win.setTitle("Bibliotheque");
						win.setLocation(500,100);
						win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						win.setSize(450,400);
						win.setVisible(true); 
						
											
						previous.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								win.setVisible(false);
								inscriptionEtudiant();
							}
							
						});
						sign.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								if(rep.getSelectedItem().equals("se desabonner")) {
									try {
										String cne,prenom,nom;
										Class.forName("com.mysql.jdbc.Driver");
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
										Statement st=con.createStatement();
										PreparedStatement posted;
										posted = con.prepareStatement("delete from etudiant where cne='"+cneinscri+"'");
										posted.executeUpdate();
										con.close();
										st.close();
									} catch (SQLException | ClassNotFoundException e) {
										e.printStackTrace();
									} 
									
								}
								else if(rep.getSelectedItem().equals("emprunter un document")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label qLabel=new Label("quel document voulez vous emprunter?");
									JComboBox<String>  rep=new JComboBox<String>();
									JButton previous=new JButton("previous page");
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									JPanel pan2=new JPanel();
									rep.addItem("la boite a merveille");
									rep.addItem("le serment des barbares");
									rep.addItem("psychopathologie");
									rep.addItem("l'imigration");
									rep.addItem("info_programme");
									rep.addItem("la_vie_des_rois");
									rep.addItem("the_end");
									rep.addItem("Gon");
									rep.addItem("property");
									rep.addItem("antigone");
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.green);
									JButton sign=new JButton("emprunter");
									rep.setPreferredSize(dim);
									pan2.add(previous);
									pan.add(qLabel);
									pan.add(rep);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.add(pan2,BorderLayout.SOUTH);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true); 
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											if(rep.getSelectedItem().equals("la boite a merveille")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='la boite a merveille' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la boite a merveille'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("le serment des barbares")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='le serment des barbares' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='le serment des barbares'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											
											else if(rep.getSelectedItem().equals("psychopathologie")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='psychopathologie' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='psychopathologie'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("l'imigration")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='l'imigration' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='l'imigration'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("info_programme")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='info_programme' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='info_programme'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("la_vie_des_rois")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='la_vie_des_rois' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la_vie_des_rois'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("the_end")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='the_end' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la boite a merveille'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("Gon")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='Gon' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='Gon'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("property")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='property' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='property'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("antigone")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='antigone' where cne='"+cneinscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='antigone'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
										
										}
									});
								}	
								else if(rep.getSelectedItem().equals("changer de mot de pass")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label passLabel=new Label("entrez le nouveau mot de passe?");
									JPasswordField pass=new JPasswordField();
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									pass.setPreferredSize(new Dimension(110,25));
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.CYAN);
									JButton sign=new JButton("Submit");
									rep.setPreferredSize(dim);
									pan.add(passLabel);
									pan.add(pass);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true);
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											//sql 
											
											try {
												
												
												
												Class.forName("com.mysql.jdbc.Driver");
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
												PreparedStatement posted;
												posted = con.prepareStatement("update etudiant set password='"+pass.getText()+"' where cne='"+cneinscri+"'");
												posted.executeUpdate();
												con.close();
											} catch (SQLException | ClassNotFoundException e) {
												e.printStackTrace();
											}
								
											
										}
										
									});
								}
								else if(rep.getSelectedItem().equals("rendre document")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label qLabel=new Label("quel document voulez vous rendre?");
									JComboBox<String>  rep=new JComboBox<String>();
									JButton previous=new JButton("previous page");
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									JPanel pan2=new JPanel();
									rep.addItem("la boite a merveille");
									rep.addItem("le serment des barbares");
									rep.addItem("psychopathologie");
									rep.addItem("l'imigration");
									rep.addItem("info_programme");
									rep.addItem("la_vie_des_rois");
									rep.addItem("the_end");
									rep.addItem("Gon");
									rep.addItem("property");
									rep.addItem("antigone");
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.green);
									JButton sign=new JButton("rendre");
									rep.setPreferredSize(dim);
									pan2.add(previous);
									pan.add(qLabel);
									pan.add(rep);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.add(pan2,BorderLayout.SOUTH);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true); 
									sign.addActionListener(new ActionListener() {

										
										public void actionPerformed(ActionEvent arg0) {
											if(rep.getSelectedItem().equals("la boite a merveile")) {
												rendreDocumentetudiant("la boite a merveille",cneinscri);
											}
											else if(rep.getSelectedItem().equals("le segment des barbares")) {
												rendreDocumentetudiant("le segment des barbares",cneinscri);
												}
											else if(rep.getSelectedItem().equals("psychopathologie")) {
												rendreDocumentetudiant("psychopathologie",cneinscri);
												}
											else if(rep.getSelectedItem().equals("l'imigration")) {
												rendreDocumentetudiant("l'imigration",cneinscri);
												}
											
											else if(rep.getSelectedItem().equals("info_programme")) {
												rendreDocumentetudiant("info_programme",cneinscri);
												}
											else if(rep.getSelectedItem().equals("la_vie_des_roi")) {
												rendreDocumentetudiant("la_vie_des_roi",cneinscri);
												}
											else if(rep.getSelectedItem().equals("the_end")) {
												rendreDocumentetudiant("the_end",cneinscri);
												}
											else if(rep.getSelectedItem().equals("Gon")) {
												rendreDocumentetudiant("Gon",cneinscri);
												}
											else if(rep.getSelectedItem().equals("property")) {
												rendreDocumentetudiant("property",cneinscri);
												}
											else if(rep.getSelectedItem().equals("antigone")) {
												rendreDocumentetudiant("antigone",cneinscri);
												}
										
										}
									});
								}
							}
						});
					}}}
			});}
			
				
	
	
	public void identifierProfesseur() {
		Dimension dim=new Dimension(100,25);
		JFrame win=new JFrame();
		Label cinLabel=new Label("cin:");
		Label nameLabel=new Label("name:");
		Label prenomLabel=new Label("prenom:");
		JTextField name=new JTextField();
		JTextField prenom=new JTextField();
		JTextField cin=new JTextField();
		JPanel pan=new JPanel();
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JButton previous=new JButton("previous page");
		pan1.setPreferredSize(new Dimension(100,80));
		pan1.setBackground(Color.yellow);
		JButton sign=new JButton("Sign up");
		name.setPreferredSize(dim);
		prenom.setPreferredSize(dim);
		cin.setPreferredSize(dim);
		pan2.add(previous);
		pan.add(cinLabel);
		pan.add(cin);
		pan.add(nameLabel);
		pan.add(name);
		pan.add(prenomLabel);
		pan.add(prenom);
		pan.add(sign);
		win.add(pan2,BorderLayout.SOUTH);
		win.add(pan,BorderLayout.CENTER);
		win.add(pan1,BorderLayout.WEST);
		win.setTitle("Bibliotheque");
		win.setLocation(500,100);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(450,400);
		win.setVisible(true);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.setVisible(false);
				authentification();
				
			}
			
		});
		
		sign.addActionListener(new ActionListener() {
			boolean flag=false;
			String nameinscri,prenominscri,cininscri,passWordinscri;
			public void actionPerformed(ActionEvent arg0) {
				nameinscri=name.getText();
				prenominscri=prenom.getText();
				cininscri=cin.getText();
				passWordinscri=passWordGenerator();
				if(!(nameinscri.equals("") && prenominscri.equals("") && cininscri.equals(""))) {
					/*Etudiant infoEtudiant=new Etudiant(nameinscri,prenominscri,cininscri,passWordinscri);
					AjouterEtudiant(infoEtudiant);*/
					
					//sql
					try {
						String cin,prenom,nom;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from professeur");
						while(rs.next()) {
							cin=rs.getString("cin");
							nom=rs.getString("nom");
							prenom=rs.getString("prenom");
							if(cininscri.equals(cin) && nameinscri.equals(nom) && prenominscri.equals(prenom)) {
								flag=true;
								break;
							}
						}
						con.close();
						st.close();
					} catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					} 

					if(flag==true) {
						Dimension dim=new Dimension(100,25);
						JFrame win=new JFrame();
						Label qLabel=new Label("que voulez vous faire?");
						JComboBox<String>  rep=new JComboBox<String>();
						JButton previous=new JButton("previous page");
						JPanel pan=new JPanel();
						JPanel pan1=new JPanel();
						JPanel pan2=new JPanel();
						rep.addItem("emprunter un document");
						rep.addItem("se desabonner");
						rep.addItem("changer de mot de pass");
						rep.addItem("rendre un document");
						rep.addItem("chercher un document par isbn");
						rep.addItem("chercher un document par titre");
						rep.addItem("chercher un document par auteur");
						pan1.setPreferredSize(new Dimension(100,80));
						pan1.setBackground(Color.green);
						JButton sign=new JButton("Submit");
						rep.setPreferredSize(dim);
						pan2.add(previous);
						pan.add(qLabel);
						pan.add(rep);
						pan.add(sign);
						win.add(pan,BorderLayout.CENTER);
						win.add(pan1,BorderLayout.WEST);
						win.add(pan2,BorderLayout.SOUTH);
						win.setTitle("Bibliotheque");
						win.setLocation(500,100);
						win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						win.setSize(450,400);
						win.setVisible(true); 
						
											
						previous.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								win.setVisible(false);
								inscriptionEtudiant();
							}
							
						});
						sign.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								if(rep.getSelectedItem().equals("se desabonner")) {
									try {
										String cne,prenom,nom;
										Class.forName("com.mysql.jdbc.Driver");
										Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
										Statement st=con.createStatement();
										PreparedStatement posted;
										posted = con.prepareStatement("delete from professeur where cin='"+cininscri+"'");
										posted.executeUpdate();
										con.close();
										st.close();
									} catch (SQLException | ClassNotFoundException e) {
										e.printStackTrace();
									} 
									
								}
								else if(rep.getSelectedItem().equals("emprunter un document")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label qLabel=new Label("quel document voulez vous emprunter?");
									JComboBox<String>  rep=new JComboBox<String>();
									JButton previous=new JButton("previous page");
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									JPanel pan2=new JPanel();
									rep.addItem("la boite a merveille");
									rep.addItem("le serment des barbares");
									rep.addItem("psychopathologie");
									rep.addItem("l'imigration");
									rep.addItem("info_programme");
									rep.addItem("la_vie_des_rois");
									rep.addItem("the_end");
									rep.addItem("Gon");
									rep.addItem("property");
									rep.addItem("antigone");
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.green);
									JButton sign=new JButton("emprunter");
									rep.setPreferredSize(dim);
									pan2.add(previous);
									pan.add(qLabel);
									pan.add(rep);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.add(pan2,BorderLayout.SOUTH);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true); 
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											if(rep.getSelectedItem().equals("la boite a merveille")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update professeur set livre_emp='la boite a merveille' where cin='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la boite a merveille'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("le serment des barbares")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update professeur set livre_emp='le serment des barbares' where cin='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='le serment des barbares'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											
											else if(rep.getSelectedItem().equals("psychopathologie")) {
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update professeur set livre_emp='psychopathologie' where cin='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='psychopathologie'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("l'imigration")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update professeur set livre_emp='l'imigration' where cin='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='l'imigration'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("info_programme")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update professeur set livre_emp='info_programme' where cin='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='info_programme'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("la_vie_des_rois")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='la_vie_des_rois' where cne='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la_vie_des_rois'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("the_end")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='the_end' where cne='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='la boite a merveille'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("Gon")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='Gon' where cne='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='Gon'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("property")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='property' where cne='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='property'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
											else if(rep.getSelectedItem().equals("antigone")){
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update etudiant set livre_emp='antigone' where cne='"+cininscri+"' ");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												}  
												
												
												try {
													String cne,prenom,nom;
													Class.forName("com.mysql.jdbc.Driver");
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
													Statement st=con.createStatement();
													PreparedStatement posted;
													posted = con.prepareStatement("update document set numberofcopy=numberofcopy-1 where title='antigone'");
													posted.executeUpdate();
													con.close();
													st.close();
												} catch (SQLException | ClassNotFoundException e) {
													e.printStackTrace();
												} 
											}
										
										}
									});
								}	
								else if(rep.getSelectedItem().equals("changer de mot de pass")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label passLabel=new Label("entrez le nouveau mot de passe?");
									JPasswordField pass=new JPasswordField();
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									pass.setPreferredSize(new Dimension(110,25));
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.CYAN);
									JButton sign=new JButton("Submit");
									rep.setPreferredSize(dim);
									pan.add(passLabel);
									pan.add(pass);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true);
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											//sql 
											
											try {
												
												
												
												Class.forName("com.mysql.jdbc.Driver");
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
												PreparedStatement posted;
												posted = con.prepareStatement("update professeur set password='"+pass.getText()+"' where cne='"+cininscri+"'");
												posted.executeUpdate();
												con.close();
											} catch (SQLException | ClassNotFoundException e) {
												e.printStackTrace();
											}
								
											
										}
										
									});
								}
								else if(rep.getSelectedItem().equals("rendre document")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label qLabel=new Label("quel document voulez vous rendre?");
									JComboBox<String>  rep=new JComboBox<String>();
									JButton previous=new JButton("previous page");
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									JPanel pan2=new JPanel();
									rep.addItem("la boite a merveille");
									rep.addItem("le serment des barbares");
									rep.addItem("psychopathologie");
									rep.addItem("l'imigration");
									rep.addItem("info_programme");
									rep.addItem("la_vie_des_rois");
									rep.addItem("the_end");
									rep.addItem("Gon");
									rep.addItem("property");
									rep.addItem("antigone");
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.green);
									JButton sign=new JButton("rendre");
									rep.setPreferredSize(dim);
									pan2.add(previous);
									pan.add(qLabel);
									pan.add(rep);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.add(pan2,BorderLayout.SOUTH);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true); 
									sign.addActionListener(new ActionListener() {

										
										public void actionPerformed(ActionEvent arg0) {
											if(rep.getSelectedItem().equals("la boite a merveile")) {
												rendreDocumentprofesseur("la boite a merveille",cininscri);
											}
											else if(rep.getSelectedItem().equals("le segment des barbares")) {
												rendreDocumentprofesseur("le segment des barbares",cininscri);
												}
											else if(rep.getSelectedItem().equals("psychopathologie")) {
												rendreDocumentprofesseur("psychopathologie",cininscri);
												}
											else if(rep.getSelectedItem().equals("l'imigration")) {
												rendreDocumentprofesseur("l'imigration",cininscri);
												}
											
											else if(rep.getSelectedItem().equals("info_programme")) {
												rendreDocumentprofesseur("info_programme",cininscri);
												}
											else if(rep.getSelectedItem().equals("la_vie_des_roi")) {
												rendreDocumentprofesseur("la_vie_des_roi",cininscri);
												}
											else if(rep.getSelectedItem().equals("the_end")) {
												rendreDocumentprofesseur("the_end",cininscri);
												}
											else if(rep.getSelectedItem().equals("Gon")) {
												rendreDocumentprofesseur("Gon",cininscri);
												}
											else if(rep.getSelectedItem().equals("property")) {
												rendreDocumentprofesseur("property",cininscri);
												}
											else if(rep.getSelectedItem().equals("antigone")) {
												rendreDocumentprofesseur("antigone",cininscri);
												}
										
										}
									});
								}
							}
						});
					}}}
			});}
														
										
											
	
								
								
		
	
	
	public void inscriptionEtudiant(){
 		Dimension dim=new Dimension(100,25);
		JFrame win=new JFrame();
		Label cneLabel=new Label("cne:");
		Label nameLabel=new Label("name:");
		Label prenomLabel=new Label("prenom:");
		JTextField name=new JTextField();
		JTextField prenom=new JTextField();
		JTextField cne=new JTextField();
		JPanel pan=new JPanel();
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JButton previous=new JButton("previous page");
		pan1.setPreferredSize(new Dimension(100,80));
		pan1.setBackground(Color.yellow);
		JButton sign=new JButton("Sign up");
		name.setPreferredSize(dim);
		prenom.setPreferredSize(dim);
		cne.setPreferredSize(dim);
		pan2.add(previous);
		pan.add(cneLabel);
		pan.add(cne);
		pan.add(nameLabel);
		pan.add(name);
		pan.add(prenomLabel);
		pan.add(prenom);
		pan.add(sign);
		win.add(pan2,BorderLayout.SOUTH);
		win.add(pan,BorderLayout.CENTER);
		win.add(pan1,BorderLayout.WEST);
		win.setTitle("Bibliotheque");
		win.setLocation(500,100);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(450,400);
		win.setVisible(true);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.setVisible(false);
				authentification();
				
			}
			
		});
		sign.addActionListener(new ActionListener() {
			String nameinscri,prenominscri,cneinscri,passWordinscri;
			boolean flag=false;
			public void actionPerformed(ActionEvent arg0) {
				nameinscri=name.getText();
				prenominscri=prenom.getText();
				cneinscri=cne.getText();
				passWordinscri=passWordGenerator();
				if(!(nameinscri.equals("") || prenominscri.equals("") ||cneinscri.equals(""))) {
					/*Etudiant infoEtudiant=new Etudiant(nameinscri,prenominscri,cneinscri,passWordinscri);
					AjouterEtudiant(infoEtudiant);
					Dimension dim=new Dimension(100,25);
					JFrame win=new JFrame();
					Label qLabel=new Label("que voulez vous faire?");
					JComboBox<String>  rep=new JComboBox<String>();
					JButton previous=new JButton("previous page");
					JPanel pan=new JPanel();
					JPanel pan1=new JPanel();
					JPanel pan2=new JPanel();
					rep.addItem("se desabonner");
					rep.addItem("changer de mot de pass");
					rep.addItem("rendre un document");
					rep.addItem("chercher un document par isbn");
					rep.addItem("chercher un document par titre");
					rep.addItem("chercher un document par auteur");
					pan1.setPreferredSize(new Dimension(100,80));
					pan1.setBackground(Color.green);
					JButton sign=new JButton("Submit");
					rep.setPreferredSize(dim);
					pan2.add(previous);
					pan.add(qLabel);
					pan.add(rep);
					pan.add(sign);
					win.add(pan,BorderLayout.CENTER);
					win.add(pan1,BorderLayout.WEST);
					win.add(pan2,BorderLayout.SOUTH);
					win.setTitle("Bibliotheque");
					win.setLocation(500,100);
					win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					win.setSize(450,400);
					win.setVisible(true);*/
					//sql
					
					try {
						String cne,prenom,nom;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from etudiant");
						//rs.next();
						while(rs.next()) {
							cne=rs.getString("cne");
							nom=rs.getString("nom");
							prenom=rs.getString("prenom");
							if(cneinscri.equals(cne) && nameinscri.equals(nom) && prenominscri.equals(prenom)) {
								flag=true;
								break;
							}
						}
						con.close();
						st.close();
					} catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					}
					if(flag==false) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
							PreparedStatement posted;
							posted = con.prepareStatement("insert into etudiant(cne,prenom,nom,password) values('"+cneinscri+"','"+prenominscri+"','"+nameinscri+"','"+passWordinscri+"')");
							posted.executeUpdate();
							con.close();
						} catch (SQLException | ClassNotFoundException e) {
							e.printStackTrace();
						} 
						
						previous.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								win.setVisible(false);
								inscriptionEtudiant();
							}
							
						});
						
						/*sign.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								if(rep.getSelectedItem().equals("se desabonner")) {
									
								}
								if(rep.getSelectedItem().equals("changer de mot de pass")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label passLabel=new Label("entrez le nouveau mot de passe?");
									JPasswordField pass=new JPasswordField();
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									pass.setPreferredSize(new Dimension(110,25));
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.CYAN);
									JButton sign=new JButton("Submit");
									rep.setPreferredSize(dim);
									pan.add(passLabel);
									pan.add(pass);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true);
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											//sql 
											
											try {
												Class.forName("com.mysql.jdbc.Driver");
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
												PreparedStatement posted;
												posted = con.prepareStatement("update etudiant set password='"+pass.getText()+"' where cne='"+cneinscri+"'");
												posted.executeUpdate();
												con.close();
											} catch (SQLException | ClassNotFoundException e) {
												e.printStackTrace();
											}
								
											
										}
										
									});
								}
								if(rep.getSelectedItem().equals("chercher un document par isbn")) {
									
								}
								if(rep.getSelectedItem().equals("chercher un document par titre")) {
									
								}
								if(rep.getSelectedItem().equals("chercher un document par auteur")) {
									
								}
								
							}
						});*/

					}
					 
					
				}

				
			}
			
		});
		
		
		
	}
	
	public void inscriptionProfesseur() {

 		Dimension dim=new Dimension(100,25);
		JFrame win=new JFrame();
		Label cinLabel=new Label("cin:");
		Label nameLabel=new Label("name:");
		Label prenomLabel=new Label("prenom:");
		JTextField name=new JTextField();
		JTextField prenom=new JTextField();
		JTextField cin=new JTextField();
		JPanel pan=new JPanel();
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		JButton previous=new JButton("previous page");
		pan1.setPreferredSize(new Dimension(100,80));
		pan1.setBackground(Color.yellow);
		JButton sign=new JButton("Sign up");
		name.setPreferredSize(dim);
		prenom.setPreferredSize(dim);
		cin.setPreferredSize(dim);
		pan2.add(previous);
		pan.add(cinLabel);
		pan.add(cin);
		pan.add(nameLabel);
		pan.add(name);
		pan.add(prenomLabel);
		pan.add(prenom);
		pan.add(sign);
		win.add(pan2,BorderLayout.SOUTH);
		win.add(pan,BorderLayout.CENTER);
		win.add(pan1,BorderLayout.WEST);
		win.setTitle("Bibliotheque");
		win.setLocation(500,100);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(450,400);
		win.setVisible(true);
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.setVisible(false);
				authentification();
				
			}
			
		});
		sign.addActionListener(new ActionListener() {
			String nameinscri,prenominscri,cininscri,passWordinscri;
			boolean flag=false;
			public void actionPerformed(ActionEvent arg0) {
				nameinscri=name.getText();
				prenominscri=prenom.getText();
				cininscri=cin.getText();
				passWordinscri=passWordGenerator();
				if(!(nameinscri.equals("") || prenominscri.equals("") ||cininscri.equals(""))) {
					/*Etudiant infoEtudiant=new Etudiant(nameinscri,prenominscri,cneinscri,passWordinscri);
					AjouterEtudiant(infoEtudiant);
					Dimension dim=new Dimension(100,25);
					JFrame win=new JFrame();
					Label qLabel=new Label("que voulez vous faire?");
					JComboBox<String>  rep=new JComboBox<String>();
					JButton previous=new JButton("previous page");
					JPanel pan=new JPanel();
					JPanel pan1=new JPanel();
					JPanel pan2=new JPanel();
					rep.addItem("se desabonner");
					rep.addItem("changer de mot de pass");
					rep.addItem("rendre un document");
					rep.addItem("chercher un document par isbn");
					rep.addItem("chercher un document par titre");
					rep.addItem("chercher un document par auteur");
					pan1.setPreferredSize(new Dimension(100,80));
					pan1.setBackground(Color.green);
					JButton sign=new JButton("Submit");
					rep.setPreferredSize(dim);
					pan2.add(previous);
					pan.add(qLabel);
					pan.add(rep);
					pan.add(sign);
					win.add(pan,BorderLayout.CENTER);
					win.add(pan1,BorderLayout.WEST);
					win.add(pan2,BorderLayout.SOUTH);
					win.setTitle("Bibliotheque");
					win.setLocation(500,100);
					win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					win.setSize(450,400);
					win.setVisible(true);*/
					//sql
					
					try {
						String cin,prenom,nom;
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select * from professeur");
						while(rs.next()) {
							cin=rs.getString("cin");
							nom=rs.getString("nom");
							prenom=rs.getString("prenom");
							if(cininscri.equals(cin) && nameinscri.equals(nom) && prenominscri.equals(prenom)) {
								flag=true;
								break;
							}
						}
						con.close();
						st.close();
					} catch (SQLException | ClassNotFoundException e) {
						e.printStackTrace();
					}
					if(flag==false) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
							PreparedStatement posted;
							posted = con.prepareStatement("insert into professeur(cin,prenom,nom,password) values('"+cininscri+"','"+prenominscri+"','"+nameinscri+"','"+passWordinscri+"')");
							posted.executeUpdate();
							con.close();
						} catch (SQLException | ClassNotFoundException e) {
							e.printStackTrace();
						} 
						
						previous.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								win.setVisible(false);
								inscriptionProfesseur();
							}
							
						});
						
						/*sign.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {
								if(rep.getSelectedItem().equals("se desabonner")) {
									
								}
								if(rep.getSelectedItem().equals("changer de mot de pass")) {
									Dimension dim=new Dimension(100,25);
									JFrame win=new JFrame();
									Label passLabel=new Label("entrez le nouveau mot de passe?");
									JPasswordField pass=new JPasswordField();
									JPanel pan=new JPanel();
									JPanel pan1=new JPanel();
									pass.setPreferredSize(new Dimension(110,25));
									pan1.setPreferredSize(new Dimension(100,80));
									pan1.setBackground(Color.CYAN);
									JButton sign=new JButton("Submit");
									rep.setPreferredSize(dim);
									pan.add(passLabel);
									pan.add(pass);
									pan.add(sign);
									win.add(pan,BorderLayout.CENTER);
									win.add(pan1,BorderLayout.WEST);
									win.setTitle("Bibliotheque");
									win.setLocation(500,100);
									win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									win.setSize(450,400);
									win.setVisible(true);
									sign.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent arg0) {
											//sql 
											
											try {
												Class.forName("com.mysql.jdbc.Driver");
												Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
												PreparedStatement posted;
												posted = con.prepareStatement("update etudiant set password='"+pass.getText()+"' where cne='"+cneinscri+"'");
												posted.executeUpdate();
												con.close();
											} catch (SQLException | ClassNotFoundException e) {
												e.printStackTrace();
											}
								
											
										}
										
									});
								}
								if(rep.getSelectedItem().equals("chercher un document par isbn")) {
									
								}
								if(rep.getSelectedItem().equals("chercher un document par titre")) {
									
								}
								if(rep.getSelectedItem().equals("chercher un document par auteur")) {
									
								}
								
							}
						});*/

					}
					 
					
				}

				
			}
			
		});
		
		
		
	}	
	
		
	//rendre un document
	public void rendreDocumentetudiant(String title,String cneinscri){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
			Statement st=con.createStatement();
			PreparedStatement posted;
			posted = con.prepareStatement("update etudiant set livre_emp=' ' where cne='"+cneinscri+"'");
			posted.executeUpdate();
			con.close();
			st.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
			Statement st=con.createStatement();
			PreparedStatement posted;
			posted = con.prepareStatement("update document set numberofcopy=numberofcopy+1 where title='"+title+"'");
			posted.executeUpdate();
			con.close();
			st.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void rendreDocumentprofesseur(String title,String cininscri){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
			Statement st=con.createStatement();
			PreparedStatement posted;
			posted = con.prepareStatement("update professeur set livre_emp=' ' where cne='"+cininscri+"'");
			posted.executeUpdate();
			con.close();
			st.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque","root","");
			Statement st=con.createStatement();
			PreparedStatement posted;
			posted = con.prepareStatement("update document set numberofcopy=numberofcopy+1 where title='"+title+"'");
			posted.executeUpdate();
			con.close();
			st.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void authentification(){
		Scanner sc=new Scanner(System.in);
		String passWord,cin,cne,rep,choixIsbn1,choixIsbn2,choixTitre,choixAuteur;
		boolean flag=false;
		int choice;
		int i=0,j=0;
		String newPass;
		//graphic 		
			String reponse; 
			Dimension dim=new Dimension(100,25);
			JFrame win=new JFrame();
			Label qLabel=new Label("vous etes un professeur ou etudiant:");
			Label qLabel1=new Label("voulez vous s'inscrire ou s'identifier:");
			JComboBox<String> qRep=new JComboBox<String>();
			JComboBox<String> qRep1=new JComboBox<String>();
			qRep.addItem("etudiant");
			qRep.addItem("professeur");
			qRep1.addItem("s'inscrire");
			qRep1.addItem("s'identifier");
			JPanel pan=new JPanel();
			JPanel pan1=new JPanel();
			JPanel pan2=new JPanel();
			pan1.setPreferredSize(new Dimension(100,80));
			pan1.setBackground(Color.red);
			JButton sign=new JButton("Submit");
			qRep.setPreferredSize(dim);
			pan.add(qLabel);
			pan.add(qRep);
			pan.add(qLabel1);
			pan.add(qRep1);
			pan.add(sign);
			win.add(pan,BorderLayout.CENTER);
			win.add(pan1,BorderLayout.WEST);
			win.setTitle("Bibliotheque");
			win.setLocation(500,100);
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setSize(500,500);
			win.setVisible(true);
			sign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(qRep.getSelectedItem().equals("etudiant")&& qRep1.getSelectedItem().equals("s'inscrire")) {
						win.setVisible(false);
						inscriptionEtudiant();
						
					}
					else if(qRep.getSelectedItem().equals("etudiant") && qRep1.getSelectedItem().equals("s'identifier")) {
						win.setVisible(false);
						identifierEtudiant();
						
					}
					else if(qRep.getSelectedItem().equals("professeur") && qRep1.getSelectedItem().equals("s'inscrire")) {
						win.setVisible(false);
						inscriptionProfesseur();
					}
					else if(qRep.getSelectedItem().equals("professeur") && qRep1.getSelectedItem().equals("s'identifier")) {
						win.setVisible(false);
						identifierProfesseur();
					}
				}
			});
				
				
			/*for(i=0;i<infoProfesseur.size();i++) {
				if(cin.equals(infoProfesseur.get(i).cin) && passWord.equals(infoProfesseur.get(i).passWord)) {
					System.out.println("HEUREUX DE VOUS REVOIR:"+infoProfesseur.get(i).prenom+" "+infoProfesseur.get(i).nom);
					System.out.println("--------------------------MENU-------------------------");
					System.out.println("QUE VOULEZ VOUS FAIRE:");
					System.out.println("1)-SE DESABONNER");
					System.out.println("2)-CHANGER DE MOT DE PASSE");
					System.out.println("3)-RENDRE UN DOCUMENT");
					System.out.println("4)-CHECHER UN DOCUMENT PAR ISBN");
					System.out.println("5)-CHECHER UN DOCUMENT PAR TITRE");
					System.out.println("6)-CHECHER UN DOCUMENT PAR AUTEUR");
					Scanner scan =new Scanner(System.in);
					choice=sc.nextInt();
					switch(choice) {
					case 1:for(Professeur ip:infoProfesseur) {
						if(ip.cin.equals(cin)) {
							SupprimerProfesseur(cin);
							break;
						}	
					};break;
					
					case 2:for(Professeur ip:this.infoProfesseur) {
								if(ip.cin.equals(cin)) {
									System.out.println("entrez votre nouveau password:");
									newPass=sc.nextLine();
									infoProfesseur.get(i).passWord=newPass;
									break;
								}
								i++;
							};break;
					case 3:System.out.println("donnez l'isbn du document que vous voulez rendre");
					choixIsbn1=sc.nextLine();
					rendreDocument(choixIsbn1);break;
					case 4:System.out.println("donnez l'isbn du document que vous voulez chercher");
					choixIsbn2=sc.nextLine();
					getDocumentByISBN(choixIsbn2);break;
					case 5:System.out.println("donnez le titre du document que vous voulez chercher");
					choixTitre=sc.nextLine();
					getDocumentByTitre(choixTitre);break;
					case 6:System.out.println("donnez l'auteur du document que vous voulez chercher");
					choixAuteur=sc.nextLine();
					getDocumentByAuteur(choixAuteur);break;
				}
					
					flag=true;
					
				}
				else {
					System.out.printf("votre password ou votre cin est incorrecte veuillez réessayer:");
					flag=false;
				}
			}
			}
			
		if(rep.equals("etudiant")) {
				//graphic
			String reponse; 
			Dimension dim=new Dimension(100,25);
			JFrame win=new JFrame();
			Label qLabel=new Label("vous etes un professeur ou etudiant:");
			JTextField qRep=new JTextField();
			JPanel pan=new JPanel();
			JPanel pan1=new JPanel();
			pan1.setPreferredSize(new Dimension(100,80));
			pan1.setBackground(Color.red);
			JButton sign=new JButton("Submit");
			qRep.setPreferredSize(dim);
			pan.add(qLabel);
			pan.add(qRep);
			pan.add(sign);
			win.add(pan,BorderLayout.CENTER);
			win.add(pan1,BorderLayout.WEST);
			win.setTitle("Bibliotheque");
			win.setLocation(500,100);
			win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			win.setSize(200,200);
			win.setVisible(true);
			sign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(qRep.getText().equals("etudiant")) {
						inscriptionEtudiant();
					}
					else if(qRep.getText().equals("professeur")) {
						inscriptionProfesseur();
					}
				}
			});
			
			
				for(i=0;i<infoEtudiant.size();i++) {
				if(cne.equals(infoEtudiant.get(i).cne) && passWord.equals(infoEtudiant.get(i).passWord)) {
					System.out.println("HEUREUX DE VOUS REVOIR:"+infoEtudiant.get(i).prenom+" "+infoEtudiant.get(i).nom);
					System.out.println("--------------------------MENU-------------------------");
					System.out.println("QUE VOULEZ VOUS FAIRE:");
					System.out.println("1)-SE DESABONNER");
					System.out.println("2)-CHANGER DE MOT DE PASS");
					System.out.println("3)-RENDRE UN DOCUMENT");
					System.out.println("4)-CHECHER UN DOCUMENT PAR ISBN");
					System.out.println("5)-CHECHER UN DOCUMENT PAR TITRE");
					System.out.println("6)-CHECHER UN DOCUMENT PAR AUTEUR");
					Scanner scan =new Scanner(System.in);
					choice=sc.nextInt();
					switch(choice) {
					case 1:for(Etudiant et:this.infoEtudiant) {
						if(et.cne.equals(cne)) {
							SupprimerEtudiant(cne);
							break;
						}	
					};break;
					
					case 2:for(Etudiant ip:this.infoEtudiant) {
						if(ip.cne.equals(cne)) {
							System.out.println("entrez votre nouveau password:");
							newPass=sc.nextLine();
							this.infoEtudiant.get(i).passWord=newPass;
							break;
						}
							
						i++;
					};break;
					case 3:System.out.println("donnez l'isbn du ducument que vous voulez rendre");
						choixIsbn1=sc.nextLine();
						rendreDocument(choixIsbn1);
					break;
					case 4:System.out.println("donnez l'isbn du ducument que vous voulez chercher");
					choixIsbn2=sc.nextLine();
					getDocumentByISBN(choixIsbn2);break;
					case 5:System.out.println("donnez le titre du ducument que vous voulez chercher");
					choixTitre=sc.nextLine();
					getDocumentByTitre(choixTitre);break;
					case 6:System.out.println("donnez l'auteur du ducument que vous voulez chercher");
					choixAuteur=sc.nextLine();
					getDocumentByAuteur(choixAuteur);break;
					}
					
					flag=true;
				}
				else {
					System.out.printf("votre password ou votre cne est incorrecte veuillez réessayer:");
					flag=false;
				}
			}
		}	*/	
			
		
		
	}
				
	
	
}
    




















