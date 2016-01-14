package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.iut.Outils.ApplicationSession;

public class ControleurTODO implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("info"), "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
