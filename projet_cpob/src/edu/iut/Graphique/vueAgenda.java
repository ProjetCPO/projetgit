package edu.iut.Graphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.iut.Outils.ApplicationSession;

public class vueAgenda extends JPanel{
	
	//Panels
		private JPanel pnlPrincipal = new JPanel();
		private JPanel pnlMenu = new JPanel();
		private static vue_Mois pnlMois;
		private static vue_Semaine pnlSemaine;
		private static vue_Jours pnlJours;
		
		//Panels
		private static JPanel pnlTemp; //référence vers le panel actuel
		
	//Layouts
		private GridLayout glMenu = new GridLayout(1,3,2,2);
		
	//Boutons
		private static JButton btnSemaine = new JButton(ApplicationSession.instance().getString("week"));
		private static JButton btnJours = new JButton(ApplicationSession.instance().getString("day"));
		private static JButton btnMois = new JButton(ApplicationSession.instance().getString("month"));
		private static JButton btnTemp; // référence vers le bouton du panel en cours
		
		private JButton tabTempButton[] = new JButton[3]; //tableau temporaire pour la gestion des evenements sur les boutons

	//Menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;		
		JMenuItem menuItem;
		
		//CONSTRUCTEUR
		public vueAgenda() {
			// TODO Auto-generated constructor stub

		//Appel des Vues

				pnlMois  = new vue_Mois();
				pnlSemaine = new vue_Semaine();
				pnlJours = new vue_Jours(ApplicationSession.instance().getString("monday"));

		//parametres de la fenetre
			this.setSize(810,650);
			this.setVisible(true);
			
		//affectation des Layouts
			pnlMenu.setLayout(glMenu);
			//this.setLayout(new GridLayout(1,2,5,5));
			pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal,BoxLayout.PAGE_AXIS));
			
		//ajout des boutons
			pnlMenu.add(btnJours);
			pnlMenu.add(btnSemaine);
			pnlMenu.add(btnMois);
			

		//ajout des objets dans le panel principal
			pnlPrincipal.add(pnlMenu);
			pnlPrincipal.add(new JLabel(" "));
			pnlPrincipal.add(pnlJours);
			pnlPrincipal.add(pnlSemaine);
			pnlPrincipal.add(pnlMois);
			
		//initialisation de la visibilité des panels à celui des Semaines
			pnlSemaine.setVisible(true);
			pnlJours.setVisible(false);
			pnlMois.setVisible(false);
			
			pnlTemp = pnlSemaine;//pnlTemp pointe donc vers pnlSemaine
			btnTemp = btnSemaine;
			
			btnTemp.setEnabled(false);
			
		//gestion des evenements pour les boutons
			tabTempButton[0] = btnJours;
			tabTempButton[1] = btnSemaine;
			tabTempButton[2] = btnMois;
			
			for(int i=0; i < tabTempButton.length; i++){
				
				final JButton btnTemp = tabTempButton[i]; //réference vers le bouton cliqué
				
				tabTempButton[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						pressButton(btnTemp);
					}
				});
			}	
		
		//MENU
			/**menu = new JMenu("file");
			menuBar.add(menu);
			this.add(menuBar);*/
		this.add(pnlPrincipal);
			
		}

		public static JButton getBtnTempModif(JButton btn) {
			pressButton(btn);
			return btnTemp;
		}

		public static void setBtnTemp(JButton btnTemp) {
			btnTemp = btnTemp;
		}

		public static JPanel getPnlTempModif() {
			return pnlTemp;
		}

		public static void setPnlTemp(JPanel pnlTemp) {
			pnlTemp = pnlTemp;
		}

		public static vue_Mois getPnlMois() {
			return pnlMois;
		}

		public static JButton getBtnSemaine() {
			return btnSemaine;
		}

		public void setBtnSemaine(JButton btnSemaine) {
			this.btnSemaine = btnSemaine;
		}

		public static JButton getBtnJours() {
			return btnJours;
		}

		public void setBtnJours(JButton btnJours) {
			this.btnJours = btnJours;
		}

		public static JButton getBtnMois() {
			return btnMois;
		}

		public void setBtnMois(JButton btnMois) {
			this.btnMois = btnMois;
		}

		public void setPnlMois(vue_Mois pnlMois) {
			this.pnlMois = pnlMois;
		}

		public static vue_Semaine getPnlSemaine() {
			return pnlSemaine;
		}

		public void setPnlSemaine(vue_Semaine pnlSemaine) {
			this.pnlSemaine = pnlSemaine;
		}

		public static vue_Jours getPnlJours() {
			return pnlJours;
		}

		public void setPnlJours(vue_Jours pnlJours) {
			this.pnlJours = pnlJours;
		}

		public static void pressButton(JButton btn){
			
			if ( btn == btnJours){
				pnlTemp.setVisible(false);
				pnlTemp = pnlJours;
				pnlTemp.setVisible(true);
				
				btnTemp.setEnabled(true);
				btnTemp = btnJours;
				btnTemp.setEnabled(false);
				}
			
			else if( btn == btnSemaine){
				pnlTemp.setVisible(false);
				pnlTemp = pnlSemaine;
				pnlTemp.setVisible(true);
				
				btnTemp.setEnabled(true);
				btnTemp = btnSemaine;
				btnTemp.setEnabled(false);	
			}
			
			else if( btn == btnMois){
				pnlTemp.setVisible(false);
				pnlTemp = pnlMois;
				pnlTemp.setVisible(true);
				
				btnTemp.setEnabled(true);
				btnTemp = btnMois;
				btnTemp.setEnabled(false);
			}
			
		}

}
