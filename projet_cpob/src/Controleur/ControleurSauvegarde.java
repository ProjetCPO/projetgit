package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import principal.Agenda;
import modeles.Soutenance;
import FileActions.Sauvegarde;
import FileActions.XMLFilter;

public class ControleurSauvegarde implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser saveFile = new JFileChooser() ; 
		
		saveFile.setFileFilter(new XMLFilter()) ; 
		int retour = saveFile.showSaveDialog((JButton) arg0.getSource());
		if(retour == JFileChooser.APPROVE_OPTION){
			// un fichier a été choisi (sortie par OK)
			// chemin absolu du fichier choisi
			String cheminFichier = saveFile.getSelectedFile().getAbsolutePath() ; 
			Sauvegarde saveXml = new Sauvegarde() ; 
			if (!cheminFichier.substring(cheminFichier.length()-4).equals(new String(".xml")))
				cheminFichier += ".xml" ; 
			
			//on envoie la liste temps pour la sauvegarde XML
			saveXml.save(Agenda.soutenances, new File(cheminFichier)) ; 
		}
	}
	
}
