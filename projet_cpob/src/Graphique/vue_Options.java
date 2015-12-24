package Graphique;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Controleur.ControleurChargement;
import Controleur.ControleurCreation;
import Controleur.ControleurLanguage;
import Controleur.ControleurModificationChoix;
import Controleur.ControleurRecherche;
import Controleur.ControleurSauvegarde;
import Controleur.ControleurSuppression;
import Outils.ApplicationSession;

public class vue_Options extends JFrame{
	private JButton btnRechercher, btnSave, btnLoad, btnLanguage;
	
	private JPanel pnlButton;	
	
	public vue_Options(){
		this.btnRechercher = new JButton(ApplicationSession.instance().getString("search"));
		this.btnSave = new JButton(ApplicationSession.instance().getString("save"));
		this.btnLoad = new JButton(ApplicationSession.instance().getString("load"));
		this.btnLanguage = new JButton(ApplicationSession.instance().getString("language"));
		
		this.pnlButton = new JPanel();
		
		this.pnlButton.add(btnRechercher);
		this.pnlButton.add(btnSave);
		this.pnlButton.add(btnLoad);
		this.pnlButton.add(btnLanguage);
		
		pnlButton.setLayout(new GridLayout(4,1,5,5));
		
		this.add(pnlButton);
		
		//RECHERCHER UNE SOUTENANCE
		this.btnRechercher.addActionListener(new ControleurRecherche()) ; 
		
		//SAUVEGARDE
		this.btnSave.addActionListener(new ControleurSauvegarde()); 
		
		//CHARGEMENT
		this.btnLoad.addActionListener(new ControleurChargement()) ;
		
		//CHANGER LA LANGUE
		this.btnLanguage.addActionListener(new ControleurLanguage()) ;  
		/**this.btnSuppr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JMenuBar menuBar = new JMenuBar();
				JMenu menu = new JMenu();		
				JMenuItem menuItem = new JMenuItem();
				
				menu = new JMenu("language");
				
				//FRANCAIS
				menuItem = new JMenuItem("French");
				menuItem.addActionListener(new ControleurLanguage());
				menu.add(menuItem);
				
				//ANGLAIS
				menuItem = new JMenuItem("English");
				menuItem.addActionListener(new ControleurLanguage());
				menu.add(menuItem);
				menuBar.add(menu);
				this.add(menuBar);
			}
			
		});*/
		
		this.setTitle(ApplicationSession.instance().getString("options"));
		this.setVisible(true);
		this.setSize(200,175);
		this.setResizable(false);
		
	}
}
