package edu.iut.Graphique;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import edu.iut.principal.Agenda;
import edu.iut.Outils.ApplicationSession;

public class vue_modifSoutenanceChoix extends JPanel {
	public static boolean estInstancie = false;
	
	private JLabel lNom = new JLabel(ApplicationSession.instance().getString("saisieEdit")) ; 
	
	private JButton btnEdit = new JButton(ApplicationSession.instance().getString("validate")) ;
	
	private JLabel lblHoraire = new JLabel(ApplicationSession.instance().getString("time")) ; 
	private JLabel lblHeure = new JLabel(ApplicationSession.instance().getString("hour")) ; 
	private JLabel lblSalle = new JLabel(ApplicationSession.instance().getString("roomAdd"));
	
	private JLabel lblDate = new JLabel("Date : ");
	private JLabel lblSlash1  = new JLabel(" / ");
	private JLabel lblSlash2  = new JLabel(" / ");
	
	//ACCESSEURS
	public JLabel getlNom() {
		return lNom;
	}
	
	public JButton getBtnSuppr() {
		return btnEdit;
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
	
	public JPanel getPnlLabelNom() {
		return pnlLabelNom;
	}
	
	public JPanel getPnlSaisirHoraire() {
		return pnlSaisirHoraire;
	}
	
	public JPanel getPnlSaisirDate() {
		return pnlSaisirDate;
	}
	
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
	private JPanel pnlLabelNom, pnlSaisirHoraire, pnlSaisirDate ; 
	
//CONSTRUCTEUR
	public vue_modifSoutenanceChoix(){
		super() ; 
		pnlLabelNom = new JPanel() ; 
		
		pnlLabelNom.add(lNom) ; 
		
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
				
		/*Date*/		
		//Spinner pour la Date
		pnlSaisirDate = new JPanel() ; 
		
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
		
		
		pnlSaisirDate.add(lblDate);
		pnlSaisirDate.add(daysSpinner) ; 
		pnlSaisirDate.add(lblSlash1);
		pnlSaisirDate.add(monthsSpinner) ; 
		pnlSaisirDate.add(lblSlash2);
		pnlSaisirDate.add(yearsSpinner); 
		
		JPanel pButton = new JPanel() ; 
		
		this.btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean trouve = true ; 
				JButton button = ((JButton) e.getSource()) ; 
				vue_modifSoutenanceChoix panel = ((vue_modifSoutenanceChoix) button.getParent().getParent()) ; 
				
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
						trouve = false ; 
						break ; 
				}
				
				if(trouve && Agenda.soutenances[i][j] != null) {
					JFrame recherchePane = new JFrame(ApplicationSession.instance().getString("edit")) ; 
					vue_modifSoutenance pnlModifSoutenance = new vue_modifSoutenance(Agenda.soutenances[i][j]) ; 
					recherchePane.add(pnlModifSoutenance) ; 
					recherchePane.setVisible(true) ; 
					recherchePane.setSize(600,400) ; 
					
					JFrame fenetre = ((JFrame) panel.getParent().getParent().getParent().getParent()) ; 
					fenetre.dispose() ; 
					vue_modifSoutenanceChoix.estInstancie = false;
				}
				else
					JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("errorSuppr"), ApplicationSession.instance().getString("error"), JOptionPane.ERROR_MESSAGE) ; 
			}
		}) ; 
		
		pButton.add(btnEdit) ; 
		
		this.add(pnlLabelNom) ; 
		this.add(pnlSaisirDate) ;
		this.add(pnlSaisirHoraire);
		this.add(pButton) ; 
		
		this.setLayout(new GridLayout(4,1));
		
	}

}
