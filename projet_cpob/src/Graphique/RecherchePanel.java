package Graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controleur.ControleurTODO;
import Outils.ApplicationSession;

public class RecherchePanel extends JPanel {
	
	private JLabel lNom = new JLabel(ApplicationSession.instance().getString("nameSearch")) ; 
	private JTextField tNom = new JTextField() ; 
	private JButton bSalle = new JButton(ApplicationSession.instance().getString("room")) ; 
	private JButton bJury = new JButton("Jury") ; 
	
	public RecherchePanel() {
		super() ; 
		
		JPanel pLabelNom = new JPanel() ; 
		pLabelNom.add(lNom) ; 
		
		JPanel pTextNom = new JPanel() ; 
		tNom.setPreferredSize(new Dimension(150,20)) ; 
		tNom.setBackground(Color.LIGHT_GRAY) ; 
		
		tNom.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (((JTextField) e.getComponent()).getText().equals(ApplicationSession.instance().getString("typeName")))
					((JTextField) e.getComponent()).setText("") ; 
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (((JTextField) e.getComponent()).getText().equals(""))
					((JTextField) e.getComponent()).setText(ApplicationSession.instance().getString("typeName")) ; 
			}
		}) ; 
		
		pTextNom.add(tNom) ; 
		
		JPanel pButton = new JPanel() ; 
		bSalle.addActionListener(new ControleurTODO()) ; 
		bJury.addActionListener(new ControleurTODO()) ; 
		
		pButton.add(bSalle) ; 
		pButton.add(bJury) ; 
		
		this.add(pLabelNom) ; 
		this.add(pTextNom) ; 
		this.add(pButton) ; 
		
		this.setLayout(new GridLayout(3,1));
	}
	
}
