package edu.iut.principal;

import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import edu.iut.modeles.Soutenance;
import edu.iut.Graphique.RecherchePanel;
import edu.iut.Graphique.vueAgenda;
import edu.iut.Graphique.vue_Accueil;
import edu.iut.Outils.ApplicationSession;

public class Agenda extends JFrame{
	public static vueAgenda GUIAgenda; 	
	//liste pour stocker les soutenances ajoutées
	//public static ArrayList<Soutenance> soutenances= new ArrayList<Soutenance>();
	
//POUR LA SUITE : Faire eventuellement une arraylist de soutenances[][] afin de socker plusieurs semaines

	public static Soutenance soutenances[][] = new Soutenance[22][5] ; //22 horaires et 5 jours
	public static Agenda agenda ; 
	
	private Agenda(String s){
		super(s);
		GUIAgenda = new vueAgenda();
		this.add(GUIAgenda);
		this.setVisible(true);
		this.setSize(700,580);
		this.setIconImage(new ImageIcon("icone.jpg").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}
	
	//Utilisation du pattern singleton
	public static Agenda instance(String s) {
		if (agenda == null)
			return new Agenda(s) ; 
		else
			return agenda ; 
	}
	
	public static void vider() {
		for(int i = 0 ; i < 22 ; ++i)
			for (int j = 0 ; j < 5 ; ++j)
				soutenances[i][j] = null ;  
	}
    
    //***********************
    //   	   MAIN 		 *
    //***********************

	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("-fr"))
				ApplicationSession.instance().setLocale(Locale.FRANCE) ; 
		}
		else
			//ApplicationSession.instance().setLocale(Locale.US) ; 
		ApplicationSession.instance().setLocale(Locale.CHINA) ; 
		vue_Accueil accueil = new vue_Accueil();
	}
	
}
