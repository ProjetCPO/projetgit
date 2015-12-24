package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import principal.Agenda;
import Graphique.vueAgenda;
import Outils.ApplicationSession;

public class ControleurLanguage implements ActionListener{

	//[A MODIFIER] A changer pour choisir la langue
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(ApplicationSession.instance().getLocale() == Locale.US) ApplicationSession.instance().setLocale(Locale.FRANCE); 
		
		else ApplicationSession.instance().setLocale(Locale.US);
		
		/**Agenda.GUIAgenda.setVisible(false);
		Agenda.GUIAgenda.setVisible(true);*/
		
		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("info2"), "Info", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
