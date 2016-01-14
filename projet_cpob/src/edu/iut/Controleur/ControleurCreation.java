package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.iut.Graphique.vue_ajoutSoutenance;
import edu.iut.Outils.ApplicationSession;

public class ControleurCreation implements ActionListener {

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!vue_ajoutSoutenance.estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			vue_ajoutSoutenance.estInstancie = true;
			
			JFrame recherchePane = new JFrame(ApplicationSession.instance().getString("addSoutFrame"));
			vue_ajoutSoutenance pnlAjoutSoutenance = new vue_ajoutSoutenance(); 
			recherchePane.add(pnlAjoutSoutenance);
			recherchePane.setVisible(true);
			recherchePane.setSize(600,400);
			
			recherchePane.addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	vue_ajoutSoutenance.estInstancie = false;
	                e.getWindow().dispose();
	            }
	        });
		}
	}
	
}
