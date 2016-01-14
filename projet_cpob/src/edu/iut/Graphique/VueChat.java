package edu.iut.Graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;

import oracle.*;
import edu.iut.modeles.Chat;

public class VueChat extends JPanel {
	
	//JLABELS
	private JLabel lPseudo = new JLabel("Saisir votre pseudo : ") ; 
	
	//JTEXTFIELDS
	private JTextField tfPseudo = new JTextField() ; 
	
	//JTEXTPANES
	private JTextPane tpText = new JTextPane() ; 
	private JTextPane tpMessage = new JTextPane() ; 
	
	//JSCROLLPANES
	private JScrollPane spText = new JScrollPane() ; 
	private JScrollPane spMessage = new JScrollPane() ; 
	
	//JBUTTONS
	private JButton bSend =  new JButton("Envoyer") ; 
	private JButton bRefresh = new JButton("Rafraîchir") ; 
	private JButton bClear = new JButton("Vider historique") ; 
	
	//JCHECKBOXES
	private JCheckBox cbRefresh = new JCheckBox("Actualisation automatique") ; 
	
	//PANELS
	private JPanel pnlText = new JPanel() ; 
	private JPanel pnlPseudo = new JPanel() ; 
	private JPanel pnlActualisation = new JPanel() ; 
	private JPanel pnlMessage = new JPanel() ; 
	
	//CONNECTION
	private Chat chat ; 
	
	//TIMER
	private Timer chrono ; 
	
	private static VueChat pChat = null ; 
	
	private VueChat() {
		super() ; 
		
		tpText.setPreferredSize(new Dimension(400,200)) ; 
		tpText.setEditable(false) ; 
		spText.setWheelScrollingEnabled(true) ; 
		spText.setViewportView(tpText) ; 
		pnlText.add(spText) ; 
		this.add(spText) ; 
		
		pnlPseudo.add(lPseudo) ; 
		tfPseudo.setPreferredSize(new Dimension(150,20)) ; 
		pnlPseudo.add(tfPseudo) ; 
		
		bClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VueChat.instance().chat.viderHistorique() ; 

				VueChat.instance().tpText.setText("") ; 
				JOptionPane.showMessageDialog(null, "L'historique a été vidé avec succès.", "Vidage de l'historique", JOptionPane.INFORMATION_MESSAGE) ; 
			}
			
		}) ; 
		
		this.add(pnlPseudo) ; 
		
		tpMessage.setPreferredSize(new Dimension(300,40)) ; 
		spMessage.setWheelScrollingEnabled(true) ; 
		spMessage.setViewportView(tpMessage) ; 
		
		tpMessage.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (((JTextPane) e.getComponent()).getText().equals("Entrer un message ici"))
					((JTextPane) e.getComponent()).setText("") ; 
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (((JTextPane) e.getComponent()).getText().equals(""))
					((JTextPane) e.getComponent()).setText("Entrer un message ici") ; 
			}
		}) ; 
		
		pnlMessage.add(spMessage) ; 
		
		bSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pseudo = VueChat.instance().tfPseudo.getText() ; 
				
				if (pseudo.length() < 1)
					JOptionPane.showMessageDialog(null, "Veuillez saisir un pseudo.", "Erreur", JOptionPane.ERROR_MESSAGE) ; 
				else {
					if (!VueChat.instance().tpMessage.getText().equals("Entrer un message ici") && !VueChat.instance().tpMessage.getText().equals("")) {
						String temp = chat.actualiser() ; 
						if (temp.length() > 3) {
							if (temp.substring(0,4).equals("null"))
								temp = temp.substring(4) ; 
						}
						else
							if (temp.equals("null"))
								temp = "" ;
						
						String text = temp + '\n' + pseudo + " : " + VueChat.instance().tpMessage.getText() ; 
						if (text.charAt(0) == '\n')
							text = text.substring(1) ; 
						VueChat.instance().chat.envoiMessage(text) ; 
						VueChat.instance().getTpText().setText(text) ; 
						VueChat.instance().tpMessage.setText("") ; 
					}
					else
						JOptionPane.showMessageDialog(null, "Veuillez saisir un message.", "Erreur", JOptionPane.ERROR_MESSAGE) ; 
				}
			}
			
		}) ; 
		
		pnlMessage.add(bSend) ; 
		
		this.add(pnlMessage) ; 

		cbRefresh.setSelected(true) ; 
		pnlActualisation.add(cbRefresh) ; 
		
		bRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VueChat.instance().actualiser() ; 
			}
			
		}) ; 
		
		pnlActualisation.add(bRefresh) ; 

		pnlActualisation.add(bClear) ; 
		
		this.add(pnlActualisation) ; 
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)) ; 
	}
	
	public static VueChat instance() {
		if (pChat == null)
			pChat = new VueChat() ; 
		return pChat ; 
	}
	
	private void actualiser() {
		String text = VueChat.instance().getChat().actualiser() ; 
		VueChat.instance().getTpText().setText(text) ; 
	}
	
	public void demarrerChrono() {
		chrono = chronoPeriodique() ; 
		chrono.start() ; 
	}
	
	private Timer chronoPeriodique() {
		ActionListener tic = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (VueChat.instance().getCbRefresh().isSelected())
					VueChat.instance().actualiser() ; 
			}
			
		} ; 
		
		return new Timer(500,tic) ; 
	}
	
	public Chat getChat() {
		return chat ; 
	}
	
	public void setChat(Chat chat) {
		this.chat = chat ; 
	}

	public JTextPane getTpText() {
		return tpText ; 
	}
	
	public JCheckBox getCbRefresh() {
		return cbRefresh ; 
	}
	
	public static void main(String[] args) {
		JFrame test = new JFrame("Université Paris-Sud") ; 
		System.err.println("\u8B1D\u8B1D");
		
		VueChat vChat = VueChat.instance() ; 
		
		vChat.setChat(new Chat()) ; 
		
		test.add(vChat) ; 
		
		String url="jdbc:oracle:thin:pnguyen/motdepasse@oracle.iut-orsay.fr:1521:etudom" ; 
		Chat.openConnection(url) ; 
		if (!vChat.getChat().prepareHisto())
			vChat.actualiser() ; 
		vChat.demarrerChrono() ; 
		
		test.pack() ; 
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
		test.setVisible(true) ; 
	}
	
}
