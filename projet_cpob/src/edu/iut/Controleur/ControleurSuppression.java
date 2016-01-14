package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import edu.iut.modeles.Soutenance;
import edu.iut.principal.Agenda;
import edu.iut.Graphique.vue_SuppressionSoutenance;
import edu.iut.Graphique.vue_ajoutSoutenance;
import edu.iut.Outils.ApplicationSession;

public class ControleurSuppression implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!vue_SuppressionSoutenance.estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			vue_SuppressionSoutenance.estInstancie = true;
			JFrame fenSupprSout = new JFrame(ApplicationSession.instance().getString("suppr?"));
			fenSupprSout.add(new vue_SuppressionSoutenance());
			fenSupprSout.setVisible(true);
			fenSupprSout.setSize(300,200);
			
			fenSupprSout.addWindowListener(new WindowAdapter()
	        {
	            @Override
	            public void windowClosing(WindowEvent e)
	            {
	            	vue_SuppressionSoutenance.estInstancie = false;
	                e.getWindow().dispose();
	            }
	        });
		}
	}
	
}
