package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Graphique.vue_modifSoutenanceChoix;
import Outils.ApplicationSession;

public class ControleurModificationChoix implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame fenEditSout = new JFrame(ApplicationSession.instance().getString("edit"));
		fenEditSout.add(new vue_modifSoutenanceChoix());
		fenEditSout.setVisible(true);
		fenEditSout.setSize(300,200);
	}
}
