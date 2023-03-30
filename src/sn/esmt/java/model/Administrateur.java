package sn.esmt.java.model;

public class Administrateur extends Personne{

	public Administrateur(int id, String nom, String prenom, String login, String password, String confirmPassword) {
		super(id, nom, prenom, login, password, confirmPassword);
	}
	
	public Administrateur(String login, String password) {
		super(login, password);
	}
	
	
	
	public Administrateur(int id, String nom, String prenom, String login, String password,
			String role, String email, String numéro) {
		super(id, nom, prenom, login, password, role, email, numéro);
	}

	public String getType() {
		return "Admin";
	}
}
