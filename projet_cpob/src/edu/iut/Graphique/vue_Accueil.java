package edu.iut.Graphique;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import edu.iut.Outils.ApplicationSession;
import edu.iut.principal.Agenda;


public class vue_Accueil extends JFrame implements ActionListener {

    // Soit un étudiant, soit un prof
    
    //***********************
    //   	ATTRIBUTS 		 *
    //***********************
    
    // JPanel
    private JPanel pnlAccueil = new JPanel();
    private JPanel pnlTexte = new JPanel();
    private JPanel pnlChoix = new JPanel();
    
    // JText
    private JLabel txtAccueil = new JLabel(ApplicationSession.instance().getString("who?"));
    
    // Boutons
    private JButton btnEtudiant = new JButton(ApplicationSession.instance().getString("student"));
    private JButton btnProf = new JButton(ApplicationSession.instance().getString("teacher"));
    
    //***********************
    //   	Constructeur 	 *
    //***********************
    
    public vue_Accueil()
    {
   	 // (***) Caractéristiques de la fenêtre (***)
   	 this.setTitle(ApplicationSession.instance().getString("titleAppli"));
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
    	pnlChoix.setLayout(new GridLayout(2,1,0,5));
    	pnlChoix.add(btnEtudiant);
    	pnlChoix.add(btnProf);
   	 
    	// (***) Panel Accueil (***)
    	pnlAccueil.setLayout(new GridLayout(2,1));
    	pnlAccueil.setBackground(Color.WHITE);
    	txtAccueil.setHorizontalAlignment(JLabel.CENTER); //pour centrer orizontaement le label
   	 pnlAccueil.add(txtAccueil);
   	 pnlAccueil.add(pnlChoix);
   	 this.add(pnlAccueil);
   	 
   	 // (***) Ajout de listeners (***)
   	 btnEtudiant.addActionListener(this);
   	 btnProf.addActionListener(this);
   	 
    }
    
    //***********************
    //     	 LISTENERS 		 *
    //***********************
    public void actionPerformed(ActionEvent e) {
   	 // On indique quel bouton a été cliqué
   	 JButton btn = (JButton) e.getSource();
   	 
   	 Agenda.type = btn.getText() ; 
   	 
   	 if (btn.getText() == ApplicationSession.instance().getString("student"))
   	 {
   		this.dispose();
   		 
   		Agenda.instance(ApplicationSession.instance().getString("studentAgenda")) ; 
   	 }
   	 
   	 if (btn.getText() == ApplicationSession.instance().getString("teacher"))
   	 {
   		this.dispose();
		Agenda.instance(ApplicationSession.instance().getString("teacherAgenda")) ; 
   	 }
    }

}
