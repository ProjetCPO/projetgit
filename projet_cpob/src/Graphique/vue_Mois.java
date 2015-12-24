package Graphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.toedter.calendar.JCalendar;

import modeles.Soutenance;
import Controleur.ControleurChargement;
import Controleur.ControleurCreation;
import Controleur.ControleurModificationChoix;
import Controleur.ControleurRecherche;
import Controleur.ControleurSauvegarde;
import Controleur.ControleurSuppression;
import FileActions.Sauvegarde;
import FileActions.XMLFilter;
import Outils.ApplicationSession;

public class vue_Mois extends JPanel {

	//Button
	private JButton ajoutSoutenance, btnModif, btnSuppr, btnOption;
	
	//Panels
	private JPanel pnlButton;
	private JPanel pnlCalendrier ; 
	
	//Calendrier
	private JCalendar calendar ; 
	
	public vue_Mois() {
		this.ajoutSoutenance = new JButton(ApplicationSession.instance().getString("addSout"));
		this.btnModif = new JButton(ApplicationSession.instance().getString("editSout"));
		this.btnSuppr = new JButton(ApplicationSession.instance().getString("supprSout"));
		this.btnOption = new JButton(ApplicationSession.instance().getString("options"));
		
		this.pnlButton = new JPanel();
		
		this.pnlButton.add(ajoutSoutenance);
		this.pnlButton.add(btnModif);
		this.pnlButton.add(btnSuppr);
		this.pnlButton.add(btnOption);
		
		this.ajoutSoutenance.addActionListener(new ControleurCreation()) ; 
		
		this.calendar = new JCalendar() ; 
		
		this.pnlCalendrier = new JPanel() ; 
		this.pnlCalendrier.setLayout(new BorderLayout()) ;
		
		this.pnlCalendrier.add(calendar, BorderLayout.CENTER) ; 
		this.pnlCalendrier.setPreferredSize(new Dimension(452,423)) ; 
		
		this.btnModif.addActionListener(new ControleurModificationChoix());
		
		this.btnOption.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				vue_Options options = new vue_Options();
			}
			
		});
		
		
		//SUPPRESSION DE SOUTENANCE
		this.btnSuppr.addActionListener(new ControleurSuppression()) ; 	
		
		this.add(pnlCalendrier) ; 
		this.add(pnlButton);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
}
