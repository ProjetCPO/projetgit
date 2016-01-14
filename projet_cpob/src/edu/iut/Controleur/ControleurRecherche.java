package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.iut.Graphique.RecherchePanel;
import edu.iut.Graphique.vue_Options;
import edu.iut.Outils.ApplicationSession;


public class ControleurRecherche implements ActionListener {
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!RecherchePanel.estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			RecherchePanel.estInstancie = true;

		
			JFrame recherchePane = new JFrame(ApplicationSession.instance().getString("search"));
			RecherchePanel pnlRecherche = new RecherchePanel(); 
			recherchePane.add(pnlRecherche);
			recherchePane.setVisible(true);
			recherchePane.setSize(300,200);
			recherchePane.addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	RecherchePanel.estInstancie = false;
	                e.getWindow().dispose();
	            }
	        });
		}
	}
}
