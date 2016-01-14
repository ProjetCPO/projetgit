package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import edu.iut.principal.Agenda;
import edu.iut.modeles.Soutenance;
import edu.iut.FileActions.Chargement;
import edu.iut.FileActions.XMLFilter;
import edu.iut.Outils.ApplicationSession;

public class ControleurChargement implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser loadFile = new JFileChooser() ; 
		
		loadFile.setFileFilter(new XMLFilter()) ; 
		int retour = loadFile.showOpenDialog((JButton) arg0.getSource());
		if(retour == JFileChooser.APPROVE_OPTION){
			// un fichier a été choisi (sortie par OK)
			// chemin absolu du fichier choisi
			String cheminFichier = loadFile.getSelectedFile().getAbsolutePath() ; 
			Chargement loadXml = new Chargement() ; 
			
			if (!cheminFichier.substring(cheminFichier.length()-4).equals(new String(".xml")))
				cheminFichier += ".xml" ; 

			boolean ok = true ; 
			//on envoie la liste temps pour la sauvegarde XML
			try {
				loadXml.load(new File(cheminFichier)) ;
			} catch (IOException e) {
				ok = false ; 
			} 
			if (!ok)
				JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorLoad"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
		}
	}
	
}
