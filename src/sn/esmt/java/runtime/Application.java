package sn.esmt.java.runtime;

import java.sql.Connection;
import javax.swing.JOptionPane;
import sn.esmt.java.dataBase.DBManager;
import sn.esmt.java.ui.Authentification;


public class Application {
	public static void main(String[] args) {
		
		Authentification authentification = new Authentification();
		authentification.lancer();
		
		try (Connection connection = DBManager.getConnection()) {
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog (null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
		}
	}
}


