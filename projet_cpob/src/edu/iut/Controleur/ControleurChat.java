package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import edu.iut.Graphique.VueChat;
import edu.iut.Outils.ApplicationSession;
import edu.iut.modeles.Chat;

public class ControleurChat implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame chat = new JFrame(ApplicationSession.instance().getString("chat")) ; 
		
		VueChat vChat = VueChat.instance() ; 
		
		vChat.setChat(new Chat()) ; 
		
		chat.add(vChat) ; 
		
		String url="jdbc:oracle:thin:pnguyen/motdepasse@oracle.iut-orsay.fr:1521:etudom" ; 
		Chat.openConnection(url) ; 
		if (!vChat.getChat().prepareHisto())
			vChat.actualiser() ; 
		vChat.demarrerChrono() ; 
		
		chat.pack() ; 
		chat.setVisible(true) ; 
	}

}
