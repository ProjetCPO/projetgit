package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.iut.Graphique.vue_ajoutSoutenance;
import edu.iut.Graphique.vue_modifSoutenanceChoix;
import edu.iut.Outils.ApplicationSession;

public class ControleurModificationChoix implements ActionListener {

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!vue_modifSoutenanceChoix.estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			vue_modifSoutenanceChoix.estInstancie = true;
			
			JFrame fenEditSout = new JFrame(ApplicationSession.instance().getString("edit"));
			fenEditSout.add(new vue_modifSoutenanceChoix());
			fenEditSout.setVisible(true);
			fenEditSout.setSize(300,200);
			
			fenEditSout.addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	vue_modifSoutenanceChoix.estInstancie = false;
	                e.getWindow().dispose();
	            }
	        });
		}
	}
}
