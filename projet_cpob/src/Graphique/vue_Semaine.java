package Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import principal.Agenda;
import modeles.Soutenance;
import Controleur.ControleurChargement;
import Controleur.ControleurCreation;
import Controleur.ControleurModificationChoix;
import Controleur.ControleurRecherche;
import Controleur.ControleurSauvegarde;
import Controleur.ControleurSuppression;
import Outils.ApplicationSession;


public class vue_Semaine extends JPanel{
	//Tableau
	private static DefaultTableModel model = new DefaultTableModel(); 
	
	private String titleTab[] = {ApplicationSession.instance().getString("monday"),
			ApplicationSession.instance().getString("tuesday"),
			ApplicationSession.instance().getString("wednesday"),
			ApplicationSession.instance().getString("thursday"),
			ApplicationSession.instance().getString("friday")};
	
	private String lignes[][] = {{"0","0","0","0","0"}};
	private static JTable tblRecherche = new JTable(model);
	
	//Button
	private JButton ajoutSoutenance, btnModif, btnSuppr, btnOption;
	
	//Panels
	private JPanel pnlButton;
	
	public vue_Semaine(){
		// initialisation du tableau de recherche
			model.addColumn(ApplicationSession.instance().getString("schedule")) ; 
			model.addColumn(ApplicationSession.instance().getString("monday"));
			model.addColumn(ApplicationSession.instance().getString("tuesday"));
			model.addColumn(ApplicationSession.instance().getString("wednesday"));
			model.addColumn(ApplicationSession.instance().getString("thursday"));
			model.addColumn(ApplicationSession.instance().getString("friday"));
			
			for (int i = 8 ; i <= 18 ; ++i) {
				model.addRow(new String[] {i + "h00", "", "", "", "", ""}) ; 
				model.addRow(new String[] {i + "h30", "", "", "", "", ""}) ;
			}
			
			this.ajoutSoutenance = new JButton(ApplicationSession.instance().getString("addSout"));
			this.btnModif = new JButton(ApplicationSession.instance().getString("editSout"));
			this.btnSuppr = new JButton(ApplicationSession.instance().getString("supprSout"));
			this.btnOption = new JButton(ApplicationSession.instance().getString("options"));
			
			
			this.pnlButton = new JPanel();
			
			this.pnlButton.add(ajoutSoutenance);
			this.pnlButton.add(btnModif);
			this.pnlButton.add(btnSuppr);
			this.pnlButton.add(btnOption);
			
			this.ajoutSoutenance.addActionListener(new ControleurCreation()) ; 

			this.btnModif.addActionListener(new ControleurModificationChoix());

			
			//SUPPRESSION DE SOUTENANCE
			this.btnSuppr.addActionListener(new ControleurSuppression()) ; 
			
			this.btnOption.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					vue_Options options = new vue_Options();
				}
				
			});
			
			this.add(new JScrollPane(tblRecherche));
			this.add(pnlButton);
			this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
			
			
	}
	
	public static void actualiser() {
		for (int i = 0 ; i < 22 ; ++i)
			for (int j = 0 ; j < 5 ; ++j)
				if (Agenda.soutenances[i][j] != null)
					tblRecherche.setValueAt(Agenda.soutenances[i][j].getSalleSout().getNom() + " " + Agenda.soutenances[i][j].getEtudiant().getNom() + " " + Agenda.soutenances[i][j].getEtudiant().getPrenom(), i, j + 1) ;
				else
					tblRecherche.setValueAt("", i, j + 1);
	}
	
	public static boolean ajoutSoutenance(Soutenance soutenance, int i, int j) {
		if (tblRecherche.getValueAt(i, j) == "") {
			tblRecherche.setValueAt(soutenance.getSalleSout().getNom() + " " + soutenance.getEtudiant().getNom() + " " + soutenance.getEtudiant().getPrenom(), i, j) ; 
			return true ; 
		}
		return false ; 
	}
	
	public static void modifSoutenance(Soutenance soutenance, int i, int j) {
		tblRecherche.setValueAt(soutenance.getSalleSout().getNom() + " " + soutenance.getEtudiant().getNom() + " " + soutenance.getEtudiant().getPrenom(), i, j) ; 
	}
	
	public static boolean suppressionSoutenance(int i, int j) {
		if (tblRecherche.getValueAt(i, j) != "") {
			tblRecherche.setValueAt("", i, j) ; 
			return true ; 
		}
		else
			return false ; 
	}

}
