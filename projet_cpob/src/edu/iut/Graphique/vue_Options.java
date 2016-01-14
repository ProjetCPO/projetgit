package edu.iut.Graphique;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.iut.principal.Agenda;
import edu.iut.Controleur.ControleurChargement;
import edu.iut.Controleur.ControleurChat;
import edu.iut.Controleur.ControleurCreation;
import edu.iut.Controleur.ControleurLanguage;
import edu.iut.Controleur.ControleurModificationChoix;
import edu.iut.Controleur.ControleurRecherche;
import edu.iut.Controleur.ControleurSauvegarde;
import edu.iut.Controleur.ControleurSuppression;
import edu.iut.Outils.ApplicationSession;

public class vue_Options extends JFrame{
	private JButton btnRechercher, btnSave, btnLoad, btnLanguage, btnChat;
	
	private JPanel pnlButton;
	
	private static boolean estInstancie = false;

	private static Component focusOwner;
	
	private vue_Options(){
		this.btnRechercher = new JButton(ApplicationSession.instance().getString("search"));
		this.btnSave = new JButton(ApplicationSession.instance().getString("save"));
		this.btnLoad = new JButton(ApplicationSession.instance().getString("load"));
		this.btnChat = new JButton(ApplicationSession.instance().getString("chat"));
		this.btnLanguage = new JButton(ApplicationSession.instance().getString("language"));
		this.btnLanguage.setEnabled(false);
		
		this.pnlButton = new JPanel();
		
		pnlButton.setLayout(new GridLayout(4,1,5,5));
		
		this.pnlButton.add(btnRechercher);
		this.pnlButton.add(btnSave);
		this.pnlButton.add(btnLoad);
		if (Agenda.type == ApplicationSession.instance().getString("teacher")) {
			this.pnlButton.add(btnChat) ; 
			pnlButton.setLayout(new GridLayout(5,1,5,5));
		}
		this.pnlButton.add(btnLanguage);
		
		this.add(pnlButton);
		
		//RECHERCHER UNE SOUTENANCE
		this.btnRechercher.addActionListener(new ControleurRecherche()) ; 
		
		//SAUVEGARDE
		this.btnSave.addActionListener(new ControleurSauvegarde()); 
		
		//CHARGEMENT
		this.btnLoad.addActionListener(new ControleurChargement()) ;
		
		//CHAT
		this.btnChat.addActionListener(new ControleurChat()) ; 
		
		//CHANGER LA LANGUE
		this.btnLanguage.addActionListener(new ControleurLanguage()) ;  
		
		
		this.setTitle(ApplicationSession.instance().getString("options"));
		this.setVisible(true);
		this.setSize(200,175);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
            	estInstancie = false;
                e.getWindow().dispose();
            }
        });
		
		
	}
	
	//Utilisation du pattern singleton
	public static vue_Options instance() {
		if (!estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			estInstancie = true;
			return new vue_Options() ; 
		}
		else{
			return null ;
		}
			
	}
}
