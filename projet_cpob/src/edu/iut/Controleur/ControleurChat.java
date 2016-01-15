package edu.iut.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import edu.iut.Graphique.VueChat;
import edu.iut.Graphique.vue_ajoutSoutenance;
import edu.iut.Outils.ApplicationSession;
import edu.iut.modeles.Chat;

public class ControleurChat implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!VueChat.estInstancie){// Pour n'avoir qu'une seule fenêtre ouverte à la fois
			VueChat.estInstancie = true;
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
			chat.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e)
				  {
					VueChat.chrono.stop();
					VueChat.estInstancie = false;
	                e.getWindow().dispose();
				  }
			
			});
		}
	}

}
