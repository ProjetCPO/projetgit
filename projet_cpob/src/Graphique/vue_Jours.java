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
import Controleur.ControleurChargement;
import Controleur.ControleurCreation;
import Controleur.ControleurModificationChoix;
import Controleur.ControleurRecherche;
import Controleur.ControleurSauvegarde;
import Controleur.ControleurSuppression;
import Outils.ApplicationSession;
import modeles.Soutenance;

public class vue_Jours extends JPanel{
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
	
	public vue_Jours(String nomJour){
	// initialisation du tableau de recherche
		this.model.addColumn(ApplicationSession.instance().getString("schedule")) ; 
		this.model.addColumn(nomJour);
		
		for (int i = 8 ; i <= 18 ; ++i) {
			this.model.addRow(new String[] {i + "h00", ""}) ; 
			this.model.addRow(new String[] {i + "h30", ""}) ;
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
			if(Agenda.soutenances[i][0] != null)
				tblRecherche.setValueAt(Agenda.soutenances[i][0].getSalleSout().getNom() + " " + Agenda.soutenances[i][0].getEtudiant().getNom() + " " + Agenda.soutenances[i][0].getEtudiant().getPrenom(), i, 1) ; 
	}
	
	public static void ajoutSoutenance(Soutenance soutenance, int i) {
		if (tblRecherche.getValueAt(i, 1) == "") {
			tblRecherche.setValueAt(soutenance.getSalleSout().getNom() + " " + soutenance.getEtudiant().getNom() + " " + soutenance.getEtudiant().getPrenom(), i, 1) ; 
		}
	}
	
	public static void modifSoutenance(Soutenance soutenance, int i) {
		tblRecherche.setValueAt(soutenance.getSalleSout().getNom() + " " + soutenance.getEtudiant().getNom() + " " + soutenance.getEtudiant().getPrenom(), i, 1) ; 
	}
	
	public static void suppressionSoutenance(int i) {
		if (tblRecherche.getValueAt(i, 1) != "") {
			tblRecherche.setValueAt("", i, 1) ; 
		}
	}
	
}
