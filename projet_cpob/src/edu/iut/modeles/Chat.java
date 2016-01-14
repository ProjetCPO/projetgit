package edu.iut.modeles;

import java.sql.*;

public class Chat {
	
	private static Connection co = null ; 
	
	public static Connection getCo() {
		return co ; 
	}
	
	public static Connection openConnection (String url) {
		if (Chat.co == null) {
			Connection co = null ; 
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver") ; 
				co = DriverManager.getConnection(url) ; 
			}
			catch (ClassNotFoundException e){
				System.err.println("il manque le driver oracle") ; 
				System.exit(1) ; 
			}
			catch (SQLException e) {
				System.err.println("impossible de se connecter à l'url : "+url) ; 
				System.exit(1) ; 
			}
			
			Chat.co = co ; 
			return co ; 
		}
		return co ; 
	}
	
	public boolean prepareHisto() {
		String verif = 
				"SELECT COUNT(*) " + 
				"FROM Historique" ; 
		try {
			PreparedStatement stmVerif = co.prepareStatement(verif) ; 
			ResultSet resVerif = stmVerif.executeQuery() ; 
			
			resVerif.next() ; 
			
			if (resVerif.getInt(1) < 1) {
				stmVerif.close() ; 
				resVerif.close() ; 
				String prepare = 
						"INSERT INTO Historique " + 
						"VALUES (1, '', 0)" ; 
				PreparedStatement stmPrepare = co.prepareStatement(prepare) ; 
				stmPrepare.executeUpdate() ; 
				
				stmPrepare.close() ; 
				
				return true ; 
			}
		} catch (SQLException e) {
			e.printStackTrace() ; 
		}
		
		return false ; 
	}
	
	public void envoiMessage(String s) {
		String verif = 
				"SELECT plein, LENGTH(text), Num " + 
				"FROM Historique " + 
				"WHERE Num = 1" ; 
		try {
			PreparedStatement stmVerif = co.prepareStatement(verif) ; 
			ResultSet resVerif = stmVerif.executeQuery() ; 
			
			resVerif.next() ; 
			
			int i = 1 ; 
			
			while (resVerif.getInt(1) == 1) {
				stmVerif.close() ; 
				resVerif.close() ; 
				++i ; 
				verif = 
					"SELECT plein, LENGTH(text), Num " + 
					"FROM Historique " + 
					"WHERE Num = " + i ; 
				
				stmVerif = co.prepareStatement(verif) ; 
				resVerif = stmVerif.executeQuery() ; 
				
				resVerif.next() ; 
			}
			
			String prepare ; 
			PreparedStatement stmPrepare ; 
			ResultSet rsPrepare ; 
			
			if (resVerif.getInt(2) + s.length() > 4000) {
				int num = resVerif.getInt(3) ; 
				stmVerif.close() ; 
				resVerif.close() ; 
				prepare = 
						"UPDATE Historique " + 
						"SET plein = 1 " + 
						"WHERE Num = " + num ; 
				stmPrepare = co.prepareStatement(prepare) ; 
				stmPrepare.executeUpdate() ; 
				stmPrepare.close() ; 
				
				prepare = 
						"INSERT INTO Historique " + 
						"VALUES (" + ++num + ", '" + s + "', 0)" ; 
				stmPrepare = co.prepareStatement(prepare) ; 
				stmPrepare.executeUpdate() ; 
				stmPrepare.close() ; 
			}
			else {
				prepare = 
						"UPDATE Historique " + 
						"SET text = '" + s + "' " + 
						"WHERE Num = 1" ; 
				stmPrepare = co.prepareStatement(prepare) ; 
				stmPrepare.executeUpdate() ; 
				stmPrepare.close() ; 
			}
		} catch (SQLException e) {
			e.printStackTrace() ; 
		}
	}
	
	public String actualiser() {
		String text = "" ; 
		String verif = 
				"SELECT plein, text " + 
				"FROM Historique " + 
				"WHERE Num = 1" ; 
		try {
			PreparedStatement stmVerif = co.prepareStatement(verif) ; 
			ResultSet resVerif = stmVerif.executeQuery() ; 
			
			resVerif.next() ; 
			
			String temp = "" + resVerif.getString(2) ; 
			
			if (!temp.equals("null"))
				text = temp ; 
			
			int i = 1 ; 
			
			while (resVerif.getInt(1) == 1) {
				stmVerif.close() ; 
				resVerif.close() ; 
				++i ; 
				verif = 
					"SELECT plein, text " + 
					"FROM Historique " + 
					"WHERE Num = " + i ; 
				
				stmVerif = co.prepareStatement(verif) ; 
				resVerif = stmVerif.executeQuery() ; 
				
				resVerif.next() ; 
				
				temp = "" + resVerif.getString(2) ; 
				if (!temp.equals("null"))
					text += temp ; 
			} 
			stmVerif.close() ; 
			resVerif.close() ; 
			
			return text ; 
		} catch (SQLException e) {
			e.printStackTrace() ; 
		}
		
		return "";
	}
	
	public void viderHistorique() {
		String chargement = 
				"SELECT MAX(Num) " + 
				"FROM Historique" ; 
		
		int numMax = 0 ; 
		
		PreparedStatement stmChargement;
		try {
			stmChargement = co.prepareStatement(chargement);
			ResultSet rsChargement = stmChargement.executeQuery() ; 
			
			rsChargement.next() ; 
			
			numMax = rsChargement.getInt(1) ; 
			stmChargement.close() ;  
			rsChargement.close() ; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (numMax > 0) {
			String suppr ; 
			try {
				
				for (int i = 1 ; i <= numMax ; ++i) {
					suppr = 
						"DELETE FROM Historique " + 
						"WHERE Num = " + i ; 
					PreparedStatement stmSuppr = co.prepareStatement(suppr) ; 
					stmSuppr.executeUpdate() ; 
					stmSuppr.close() ; 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			prepareHisto() ; 
		}
	}
	
}
