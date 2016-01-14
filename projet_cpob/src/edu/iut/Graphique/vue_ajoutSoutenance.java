package edu.iut.Graphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.Document;

import edu.iut.principal.Agenda;
import edu.iut.modeles.Personne;
import edu.iut.modeles.Salle;
import edu.iut.modeles.Soutenance;
import edu.iut.Outils.ApplicationSession;

public class vue_ajoutSoutenance extends JPanel{
	public static boolean estInstancie = false;
	
	//Labels
	private JLabel lblAjout;
	private JLabel lblNom = new JLabel(ApplicationSession.instance().getString("studentLName")) ; 
	private JLabel lblPrenom = new JLabel(ApplicationSession.instance().getString("studentFName")) ; 
	private JLabel lblHoraire = new JLabel(ApplicationSession.instance().getString("time")) ; 
	private JLabel lblHeure = new JLabel(ApplicationSession.instance().getString("hour")) ; 
	private JLabel lblSalle = new JLabel(ApplicationSession.instance().getString("roomAdd"));
	private JLabel lblDate = new JLabel("Date : ");
	private JLabel lblSlash1  = new JLabel(" / ");
	private JLabel lblSlash2  = new JLabel(" / ");
	private JLabel lblNbJury = new JLabel("Jury : ");
	private JLabel lblMbIUT = new JLabel(ApplicationSession.instance().getString("institMember"));
	private JLabel lblMbPro = new JLabel(ApplicationSession.instance().getString("profMember"));
	
	//TextField
	private JTextField tfSalle = new JTextField();
	private JTextField tfNom = new JTextField() ; 
	private JTextField tfPrenom = new JTextField() ; 
	private JTextField tfNbPro = new JTextField();
	private JTextField tfNbIUT = new JTextField();
	
	//Buttons
	private JButton btnValider = new JButton(ApplicationSession.instance().getString("validate"));
	//JButton  btnAjoutRapport = new JButton("Ajouter un rapport"); 
	
	//Spinners
	private SpinnerNumberModel hourModel ; 
	private JSpinner hoursSpinner ; 
	private SpinnerNumberModel minuteModel ; 
	private JSpinner minutesSpinner ;
	
	private SpinnerNumberModel dayModel ; 
	private JSpinner daysSpinner ; 
	private SpinnerNumberModel monthModel ; 
	private JSpinner monthsSpinner ; 
	private SpinnerNumberModel yearModel ; 
	private JSpinner yearsSpinner ; 
	
	//Panels
	private JPanel pnlTitre;
	private JPanel pnlSaisirNom ; 
	private JPanel pnlSaisirHoraire ; 
	private JPanel pnlSaisirDate;
	private JPanel pnlSaisirJuryNbIUT;
	private JPanel pnlSaisirJuryPro;
	private JPanel pnlButtonV;
	
	private JPanel pnlSalle; 
	private JPanel pnlSaisirJury;
	
//ACCESSEURS
	public JLabel getLblAjout() {
		return lblAjout;
	}

	public JLabel getLblNom() {
		return lblNom;
	}

	public JLabel getLblPrenom() {
		return lblPrenom;
	}

	public JLabel getLblHoraire() {
		return lblHoraire;
	}

	public JLabel getLblHeure() {
		return lblHeure;
	}

	public JLabel getLblSalle() {
		return lblSalle;
	}

	public JLabel getLblDate() {
		return lblDate;
	}

	public JLabel getLblSlash1() {
		return lblSlash1;
	}

	public JLabel getLblSlash2() {
		return lblSlash2;
	}

	public JLabel getLblNbJury() {
		return lblNbJury;
	}

	public JLabel getLblMbIUT() {
		return lblMbIUT;
	}

	public JLabel getLblMbPro() {
		return lblMbPro;
	}

	public JTextField getTfSalle() {
		return tfSalle;
	}

	public JTextField getTfNom() {
		return tfNom;
	}

	public JTextField getTfPrenom() {
		return tfPrenom;
	}

	public JTextField getTfNbPro() {
		return tfNbPro;
	}

	public JTextField getTfNbIUT() {
		return tfNbIUT;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public SpinnerNumberModel getHourModel() {
		return hourModel;
	}

	public JSpinner getHoursSpinner() {
		return hoursSpinner;
	}

	public SpinnerNumberModel getMinuteModel() {
		return minuteModel;
	}

	public JSpinner getMinutesSpinner() {
		return minutesSpinner;
	}

	public SpinnerNumberModel getDayModel() {
		return dayModel;
	}

	public JSpinner getDaysSpinner() {
		return daysSpinner;
	}

	public SpinnerNumberModel getMonthModel() {
		return monthModel;
	}

	public JSpinner getMonthsSpinner() {
		return monthsSpinner;
	}

	public SpinnerNumberModel getYearModel() {
		return yearModel;
	}

	public JSpinner getYearsSpinner() {
		return yearsSpinner;
	}

	public JPanel getPnlTitre() {
		return pnlTitre;
	}

	public JPanel getPnlSaisirNom() {
		return pnlSaisirNom;
	}

	public JPanel getPnlSaisirHoraire() {
		return pnlSaisirHoraire;
	}

	public JPanel getPnlSaisirDate() {
		return pnlSaisirDate;
	}

	public JPanel getPnlSaisirJuryNbIUT() {
		return pnlSaisirJuryNbIUT;
	}

	public JPanel getPnlSaisirJuryPro() {
		return pnlSaisirJuryPro;
	}

	public JPanel getPnlButtonV() {
		return pnlButtonV;
	}

	public JPanel getPnlSalle() {
		return pnlSalle;
	}

	public JPanel getPnlSaisirJury() {
		return pnlSaisirJury;
	}

//CONSTRUCTEUR
	public vue_ajoutSoutenance(){
		super() ;
		
		//PANELS
		pnlTitre = new JPanel();
		pnlSaisirDate = new JPanel();
		pnlSaisirJuryNbIUT = new JPanel();
		pnlSaisirJuryPro = new JPanel();
		pnlButtonV = new JPanel();
		pnlSaisirJury = new JPanel();
		
		pnlSalle = new JPanel(); 
		
		this.setLayout(new GridLayout(7,1));
	/*Titre*/
		lblAjout = new JLabel(ApplicationSession.instance().getString("addSout"));
		lblAjout.setHorizontalAlignment(JLabel.CENTER); //pour centrer horizontalement le label
		
		pnlTitre = new JPanel();
		pnlTitre.setLayout(new BorderLayout());
		pnlTitre.add(lblAjout, BorderLayout.CENTER);
		this.add(pnlTitre);
		
	/*Nom*/
		pnlSaisirNom = new JPanel() ; 
		
		pnlSaisirNom.add(lblNom) ; 
		tfNom.setPreferredSize(new Dimension(150,20)) ; 
		tfNom.setBackground(Color.LIGHT_GRAY); 
		pnlSaisirNom.add(tfNom) ; 
		
		pnlSaisirNom.add(lblPrenom) ; 
		tfPrenom.setPreferredSize(new Dimension(150,20)) ; 
		tfPrenom.setBackground(Color.LIGHT_GRAY); 
		pnlSaisirNom.add(tfPrenom) ; 
		
	/*Heure*/
		
		pnlSaisirHoraire = new JPanel() ; 
		
		hourModel = new SpinnerNumberModel(8,
										   8,
										   18,
										   1) ; 

		hoursSpinner = new JSpinner(hourModel) ; 
		hoursSpinner.setEditor(new JSpinner.NumberEditor(hoursSpinner, "#")) ; 
		
		minuteModel = new SpinnerNumberModel(0,
				  							 0,
				  							 30,
				  							 30) ; 

		minutesSpinner = new JSpinner(minuteModel) ; 
		minutesSpinner.setEditor(new JSpinner.NumberEditor(minutesSpinner, "#")) ; 
		
		pnlSaisirHoraire.add(lblHoraire) ; 
		pnlSaisirHoraire.add(hoursSpinner) ; 
		pnlSaisirHoraire.add(lblHeure) ; 
		pnlSaisirHoraire.add(minutesSpinner) ; 
		
		
	/*Pour Salle,Date et Nb de Jury*/
		/*Date*/		
			//Spinner pour la Date
		Calendar calendar = Calendar.getInstance();
		
		dayModel = new SpinnerNumberModel(1,
										  1,
										  31,
										  1) ; 

		daysSpinner = new JSpinner(dayModel) ; 
		daysSpinner.setEditor(new JSpinner.NumberEditor(daysSpinner, "#")) ; 
		
		monthModel = new SpinnerNumberModel(1,
											1,
											12,
											1) ; 
		
		monthsSpinner = new JSpinner(monthModel) ; 
		monthsSpinner.setEditor(new JSpinner.NumberEditor(monthsSpinner, "#")) ; 
		
		yearModel = new SpinnerNumberModel(calendar.get(Calendar.YEAR),
										   calendar.get(Calendar.YEAR)-5,
										   calendar.get(Calendar.YEAR)+5,
										   1);
		
		yearsSpinner = new JSpinner(yearModel);
		yearsSpinner.setEditor(new JSpinner.NumberEditor(yearsSpinner, "#"));
		
			//1 ComboBox pour le mois 
		/*JComboBox<String> cbMois = new JComboBox<String>();
		cbMois.addItem(ApplicationSession.instance().getString("january"));cbMois.addItem(ApplicationSession.instance().getString("february"));cbMois.addItem(ApplicationSession.instance().getString("march"));
		cbMois.addItem(ApplicationSession.instance().getString("april"));cbMois.addItem(ApplicationSession.instance().getString("may"));cbMois.addItem(ApplicationSession.instance().getString("june"));
		cbMois.addItem(ApplicationSession.instance().getString("july"));cbMois.addItem(ApplicationSession.instance().getString("august"));cbMois.addItem(ApplicationSession.instance().getString("september"));
		cbMois.addItem(ApplicationSession.instance().getString("october"));cbMois.addItem(ApplicationSession.instance().getString("november"));cbMois.addItem(ApplicationSession.instance().getString("december"));*/
		
		pnlSaisirDate.add(lblDate);
		pnlSaisirDate.add(daysSpinner) ; 
		pnlSaisirDate.add(lblSlash1);
		//pnlSaisirDate.add(cbMois);
		pnlSaisirDate.add(monthsSpinner) ; 
		pnlSaisirDate.add(lblSlash2);
		pnlSaisirDate.add(yearsSpinner);
		
		
		/*Jury*/
		pnlSaisirJuryNbIUT.add(tfNbIUT);
		//Modification de la textField
		tfNbIUT.setPreferredSize(new Dimension(50,20)) ; 
		tfNbIUT.setBackground(Color.LIGHT_GRAY); 
		
		pnlSaisirJuryNbIUT.add(lblMbIUT);
		
		pnlSaisirJuryPro.add(tfNbPro);
      //Modification de la textField
		tfNbPro.setPreferredSize(new Dimension(50,20)) ; 
		tfNbPro.setBackground(Color.LIGHT_GRAY);
		
		pnlSaisirJuryPro.add(lblMbPro);
		
		pnlSalle.add(lblSalle);
		pnlSalle.add(tfSalle);
		//Modification de la textField
		tfSalle.setPreferredSize(new Dimension(50,20)) ; 
		tfSalle.setBackground(Color.LIGHT_GRAY); 
		
		//PANEL POUR LA SAISIE DU JURY
		pnlSaisirJury.add(lblNbJury);
		pnlSaisirJury.add(pnlSaisirJuryNbIUT);
		pnlSaisirJury.add(pnlSaisirJuryPro);
		
    /*Buttons*/
       
		//pnlButtonA.add(btnAjoutRapport, BorderLayout.WEST);
		
		
		pnlButtonV.add(btnValider);
		
		this.add(pnlTitre);	
		this.add(pnlSalle);
		this.add(pnlSaisirNom) ; 
		this.add(pnlSaisirHoraire) ; 
		this.add(pnlSaisirDate);
		this.add(pnlSaisirJury);
		this.add(pnlButtonV);
		
		btnValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean ok = true ; 
				
				JButton button = ((JButton) e.getSource()) ; 
				vue_ajoutSoutenance panel = ((vue_ajoutSoutenance) button.getParent().getParent()) ; 
				
				Personne etudiant = null ; 
				
				if (!panel.getTfNom().getText().isEmpty() && !panel.getTfPrenom().getText().isEmpty())
					etudiant = new Personne(panel.getTfNom().getText(), panel.getTfPrenom().getText()) ; 
				else
					ok = false ; 
				
				if (ok) {
					ArrayList<Personne> jury = new ArrayList<Personne>() ; 
					
					if (!panel.getTfNbIUT().getText().isEmpty() && !panel.getTfPrenom().getText().isEmpty()) {
						try {
						int nbJurys = Integer.parseInt(panel.getTfNbIUT().getText()) + Integer.parseInt(panel.getTfNbPro().getText()) ; 
						for (int i = 0 ; i < nbJurys ; ++i)
							jury.add(new Personne()) ;
						} catch (Exception ex) {
							ok = false ; 
						}
					}
					else
						ok = false ; 
					
					if (ok) {
						Salle salle = null ; 
						
						if (!panel.getTfSalle().getText().isEmpty())
							salle = new Salle(panel.getTfSalle().getText()) ; 
						else
							ok = false ; 
						
						if (ok) {
							ArrayList<Document> documents = new ArrayList<Document>() ; 
							
							int i = 0, j = 0 ; 
							
							switch ((Integer) panel.getHoursSpinner().getValue()) {
								case 8 : 
									i = 0 ; 
									break ; 
								case 9 : 
									i = 2 ; 
									break ; 
								case 10 : 
									i = 4 ; 
									break ; 
								case 11 : 
									i = 6 ; 
									break ; 
								case 12 : 
									i = 8 ; 
									break ; 
								case 13 : 
									i = 10 ; 
									break ; 
								case 14 : 
									i = 12 ; 
									break ; 
								case 15 : 
									i = 14 ; 
									break ; 
								case 16 : 
									i = 16 ; 
									break ; 
								case 17 : 
									i = 18 ; 
									break ; 
								case 18 : 
									i = 20 ; 
									break ; 
							}
							
							if ((Integer) panel.getMinutesSpinner().getValue() == 30)
								++i ; 
							
							Date date = new Date((Integer) panel.getYearsSpinner().getValue() - 1900,
												 (Integer) panel.getMonthsSpinner().getValue() - 1,
												 (Integer) panel.getDaysSpinner().getValue(),
												 (Integer) panel.getHoursSpinner().getValue(),
												 (Integer) panel.getMinutesSpinner().getValue()) ; 
							
							switch (date.toString().substring(0,3)) {
								case "Mon" : 
									j = 0 ; 
									break ; 
								case "Tue" : 
									j = 1 ; 
									break ; 
								case "Wed" : 
									j = 2 ; 
									break ; 
								case "Thu" : 
									j = 3 ; 
									break ; 
								case "Fri" : 
									j = 4 ; 
									break ; 
								default : 
									ok = false ; 
									break ; 
							}
							Soutenance soutenance = new Soutenance(date, etudiant, jury, salle, documents) ; 
							
								if (ok) {
									ok = vue_Semaine.ajoutSoutenance(soutenance, i, j+1) ; 
									
									if (ok) {
										if (j == 0) // Si c'est lundi
											vue_Jours.ajoutSoutenance(soutenance, i) ; 
										
										Agenda.soutenances[i][j] = soutenance ; 
										
										JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("addMsg"), ApplicationSession.instance().getString("addSoutFrame"), JOptionPane.INFORMATION_MESSAGE) ; 
										
										JFrame fenetre = ((JFrame) panel.getParent().getParent().getParent().getParent()) ; 
										fenetre.dispose() ; 
										vue_ajoutSoutenance.estInstancie = false;
									}
									else
										JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorDate2"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
								}
								else {
									JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorDate1"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
								}
						}
						else {
							JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorRoom"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
						}
					}
					else {
						JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorNb"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
					}
				}
				else {
					JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorMsgName"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
				}
			}
			
		}) ; 
	}
		
}
