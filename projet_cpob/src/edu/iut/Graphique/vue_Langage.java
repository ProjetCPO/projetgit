package edu.iut.Graphique;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Locale;

import javax.swing.*;

import edu.iut.Outils.ApplicationSession;
import edu.iut.principal.Agenda;


public class vue_Langage extends JFrame implements ActionListener {

    // Soit un étudiant, soit un prof
    
    //***********************
    //   	ATTRIBUTS 		 *
    //***********************
    
    // JPanel
    private JPanel pnlLangage = new JPanel();
    private JPanel pnlTexte = new JPanel();
    private JPanel pnlChoix = new JPanel();
    
    // JText
    private JLabel txtAccueil = new JLabel("Choose a language");
    
    // Boutons
    private JButton btnAnglais = new JButton("English");
    private JButton btnFrancais = new JButton("Français");
    private JButton btnChinois = new JButton("\u4E2D\u6587");
    
    //***********************
    //   	Constructeur 	 *
    //***********************
    
    public vue_Langage()
    {
   	 // (***) Caractéristiques de la fenêtre (***)
   	 this.setTitle("Language");
   	 this.setSize(280,170);
   	 this.setLocationRelativeTo(null); // centrer la fenêtre
   	 this.setResizable(false);
   	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        	 
    	this.setVisible(true);
    	//this.setIconImage(new ImageIcon("Image.png").getImage());
    
   	 // (***) Panel Choix (***)
    	//pnlChoix.setLayout(new BoxLayout(pnlChoix, BoxLayout.PAGE_AXIS));
    	//pnlChoix.setLayout(new GridLayout(2,1));
    	pnlChoix.setBackground(Color.WHITE);
    	pnlChoix.setLayout(new GridLayout(3,1,0,5));
    	pnlChoix.add(btnFrancais);
    	pnlChoix.add(btnAnglais);
    	pnlChoix.add(btnChinois);
   	 
    	// (***) Panel Accueil (***)
    	pnlLangage.setLayout(new GridLayout(2,1));
    	pnlLangage.setBackground(Color.WHITE);
    	txtAccueil.setHorizontalAlignment(JLabel.CENTER); //pour centrer orizontaement le label
   	 pnlLangage.add(txtAccueil);
   	 pnlLangage.add(pnlChoix);
   	 this.add(pnlLangage);
   	 
   	 // (***) Ajout de listeners (***)
   	 btnAnglais.addActionListener(this);
   	 btnFrancais.addActionListener(this);
   	 btnChinois.addActionListener(this);
   	 
    }
    
    //***********************
    //     	 LISTENERS 		 *
    //***********************
    public void actionPerformed(ActionEvent e) {
   	 // On indique quel bouton a été cliqué
   	 JButton btn = (JButton) e.getSource();
   	 
   	 switch (btn.getText()) {
   	 	case "English" :
   			ApplicationSession.instance().setLocale(Locale.US) ; 
   			break ; 
   	 	case "Français" :
   			ApplicationSession.instance().setLocale(Locale.FRANCE) ; 
   			break ; 
   	 	case "\u4E2D\u6587" :
   	 		ApplicationSession.instance().setLocale(Locale.CHINA) ; 
   	 		break ; 
   	 }
   	 
   	 this.dispose() ; 
   	 vue_Accueil accueil = new vue_Accueil() ; 

    }
}
