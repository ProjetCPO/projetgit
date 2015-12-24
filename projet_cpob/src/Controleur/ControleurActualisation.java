package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Graphique.vue_Jours;
import Graphique.vue_Semaine;
import Outils.ApplicationSession;

public class ControleurActualisation implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vue_Semaine.actualiser() ; 
		vue_Jours.actualiser() ; 
		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("refreshMsg"), ApplicationSession.instance().getString("refresh"), JOptionPane.INFORMATION_MESSAGE) ; 
	}
	
}
