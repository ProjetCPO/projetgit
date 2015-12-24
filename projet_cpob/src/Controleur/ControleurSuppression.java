package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modeles.Soutenance;
import principal.Agenda;
import Graphique.vue_SuppressionSoutenance;
import Graphique.vue_ajoutSoutenance;
import Outils.ApplicationSession;

public class ControleurSuppression implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame fenSupprSout = new JFrame(ApplicationSession.instance().getString("suppr?"));
		fenSupprSout.add(new vue_SuppressionSoutenance());
		fenSupprSout.setVisible(true);
		fenSupprSout.setSize(300,200);
	}
	
}
