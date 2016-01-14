package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import edu.iut.principal.Agenda;
import edu.iut.Graphique.vueAgenda;
import edu.iut.Outils.ApplicationSession;

public class ControleurLanguage implements ActionListener{

	//[A MODIFIER] A changer pour choisir la langue
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ApplicationSession.instance().getLocale() == Locale.US) ApplicationSession.instance().setLocale(Locale.FRANCE); 
		
		else ApplicationSession.instance().setLocale(Locale.US);
		
		/**Agenda.agenda.dispose();
		Agenda.instance(ApplicationSession.instance().getString("studentAgenda")) ; */
		
		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("info2"), "Info", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
