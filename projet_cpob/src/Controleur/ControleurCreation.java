package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Graphique.vue_ajoutSoutenance;
import Outils.ApplicationSession;

public class ControleurCreation implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame recherchePane = new JFrame(ApplicationSession.instance().getString("addSoutFrame"));
		vue_ajoutSoutenance pnlAjoutSoutenance = new vue_ajoutSoutenance(); 
		recherchePane.add(pnlAjoutSoutenance);
		recherchePane.setVisible(true);
		recherchePane.setSize(600,400);
	}
	
}
