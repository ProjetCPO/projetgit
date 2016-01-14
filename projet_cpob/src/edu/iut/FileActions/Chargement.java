package edu.iut.FileActions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import edu.iut.modeles.Personne;
import edu.iut.modeles.Salle;
import edu.iut.modeles.Soutenance;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.iut.Graphique.vue_Jours;
import edu.iut.Graphique.vue_Semaine;
import edu.iut.Outils.ApplicationSession;
import edu.iut.principal.Agenda;

public class Chargement {

	public Chargement(){}
	
	public void load(java.io.File xmlfile) throws IOException {
		Agenda.vider() ; 
		
		ArrayList<Soutenance> data = new ArrayList<Soutenance>() ; 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ; 
		try {
			DocumentBuilder builder = factory.newDocumentBuilder() ; 
			Document document= builder.parse(xmlfile) ; 
			// EX1: Lire un Document XML
			Element root = document.getDocumentElement() ; 
			NodeList rootChildren = root.getElementsByTagName("Schedule") ; 
			for (int ci = 0 ; ci < rootChildren.getLength() ; ++ci) {
				if (rootChildren.item(ci).getNodeType() == Node.ELEMENT_NODE) {
					Node child = (Element)rootChildren.item(ci) ; 
					if (child.hasAttributes()) {
						NamedNodeMap attributes = child.getAttributes() ; 
						for (int att_i = 0 ; att_i < attributes.getLength() ; ++att_i) {
							Attr attribute = (Attr)attributes.item(att_i) ; 
							
							int day = 0, month = 0, year = 0, hour = 0, minute = 0 ; 
							
							//day
							switch (attribute.getTextContent().toString().substring(0, 3)) {
								case "Mon" : 
									day = 1 ; 
									break ; 
								case "Tue" : 
									day = 2 ; 
									break ; 
								case "Wed" : 
									day = 3 ; 
									break ; 
								case "Thu" : 
									day = 4 ; 
									break ; 
								case "Fri" : 
									day = 5 ; 
									break ; 
							}
							
							//month
							switch (attribute.getTextContent().toString().substring(4, 7)) {
								case "Jan" : 
									month = 0 ; 
									break ; 
								case "Feb" : 
									month = 1 ; 
									break ; 
								case "Mar" : 
									month = 2 ; 
									break ; 
								case "Apr" : 
									month = 3 ; 
									break ; 
								case "May" : 
									month = 4 ; 
									break ; 
								case "Jun" : 
									month = 5 ; 
									break ; 
								case "Jul" : 
									month = 6 ; 
									break ; 
								case "Aug" : 
									month = 7 ; 
									break ; 
								case "Sep" : 
									month = 8 ; 
									break ; 
								case "Oct" : 
									month = 9 ; 
									break ; 
								case "Nov" : 
									month = 10 ; 
									break ; 
								case "Dec" : 
									month = 11 ; 
									break ; 
							}
							
							//year
							year = Integer.parseInt(attribute.getTextContent().toString().substring(attribute.getTextContent().length()-4, attribute.getTextContent().length())) ; 
							
							//hour
							hour = Integer.parseInt(attribute.getTextContent().toString().substring(11, 13)) ; 
							
							//minute
							minute = Integer.parseInt(attribute.getTextContent().toString().substring(14, 16)) ; 
							
							Date date = new Date(year-1900, month-1, day, hour, minute) ; 
							
							Element schedule = ((Element) child) ; 
							NodeList scheduleChildren = schedule.getElementsByTagName("Defense") ; 
							
							for (int cj = 0 ; cj < scheduleChildren.getLength() ; ++cj) {
								if (scheduleChildren.item(cj).getNodeType() == Node.ELEMENT_NODE) {
									Node child2 = (Element)scheduleChildren.item(cj) ; 
									if (child2.hasAttributes()) {
										
										String nomSalle = "", nom = "", prenom = "" ; 
										ArrayList<Personne> jury = new ArrayList<Personne>() ; 
										ArrayList<Document> documents = new ArrayList<Document>() ; 
										int nbJury = 0, nbDocument = 0 ; 
										Personne etudiant = null ; 
										Salle salle = null ; 
										
										NamedNodeMap attributes2 = child2.getAttributes() ; 
										for (int att_j = 0 ; att_j < attributes2.getLength() ; ++att_j) {
											Attr attribute2 = (Attr)attributes2.item(att_j) ; 
											
											switch(attribute2.getName()) {
												case "classroom" : 
													nomSalle = attribute2.getTextContent() ; 
													break ; 
												case "documents" : 
													nbDocument = Integer.parseInt(attribute2.getTextContent()) ; 
													break ; 
												case "juries" : 
													nbJury = Integer.parseInt(attribute2.getTextContent()) ; 
													break ; 
												case "studentfirstname" : 
													prenom = attribute2.getTextContent() ; 
													break ; 
												case "studentlastname" : 
													nom = attribute2.getTextContent() ; 
													break ; 
											}
										}
										
										etudiant = new Personne(nom, prenom) ; 
										salle = new Salle(nomSalle) ; 
										
										for (int i = 0 ; i < nbJury ; ++i)
											jury.add(new Personne()) ; 
										//TODO Quelque chose pour les documents
										
										Soutenance soutenance = new Soutenance(date, etudiant, jury, salle, new ArrayList<javax.swing.text.Document>()) ; 
										
										int i = 0, j = day - 1 ; 
										
										switch (hour) {
											case 8 : 
												i = 0 ; 
												break ; 
											case 9 : 
												i = 2 ; 
												break ; 
											case 10 : 
												i = 4 ; 
												break ; 
											case 11 : 
												i = 6 ; 
												break ; 
											case 12 : 
												i = 8 ; 
												break ; 
											case 13 : 
												i = 10 ; 
												break ; 
											case 14 : 
												i = 12 ; 
												break ; 
											case 15 : 
												i = 14 ; 
												break ; 
											case 16 : 
												i = 16 ; 
												break ; 
											case 17 : 
												i = 18 ; 
												break ; 
											case 18 : 
												i = 20 ; 
												break ; 
										}
									
										if (minute == 30)
											++i ; 
										
										Agenda.soutenances[i][j] = soutenance ; 
									}
								}
							}
							
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vue_Semaine.actualiser() ; 
		vue_Jours.actualiser() ; 

		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("loadSuccess"), ApplicationSession.instance().getString("load"), JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
