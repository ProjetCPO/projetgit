package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Graphique.RecherchePanel;
import Outils.ApplicationSession;

public class ControleurRecherche implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame recherchePane = new JFrame(ApplicationSession.instance().getString("search"));
		RecherchePanel pnlRecherche = new RecherchePanel(); 
		recherchePane.add(pnlRecherche);
		recherchePane.setVisible(true);
		recherchePane.setSize(300,200);
	}
}
